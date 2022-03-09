package com.du.feheadstudio.controller;


import cn.hutool.db.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.du.feheadstudio.entity.CurrentUser;
import com.du.feheadstudio.entity.User;
import com.du.feheadstudio.entity.UserDto;
import com.du.feheadstudio.mapper.UserMapper;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Du425
 * @since 2022-03-06
 */
@Controller
@RequestMapping("api/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/register")
    public CommonResult register(@RequestParam("nickname")@NotBlank String nickname,
                                 @Validated @RequestParam("email")@NotBlank String email,
                                 @Validated @RequestParam("telephone")@NotBlank String telephone,
                                 @Validated @RequestParam("password")@NotBlank String password) {
        User oldUser = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getTelephone, telephone));
        if (oldUser != null){
            return CommonResult.failed("该号码已被注册，注册失败");
        }
        final User user = new User(){{
            setNickname(nickname);
            setPassword(passwordEncoder.encode(password));
            setEmail(email);
            setTelephone(telephone);
        }};
        boolean save = userService.save(user);
        if (save){
            return CommonResult.success("注册成功");
        }
        return CommonResult.failed("注册失败");

    }

    /**
     * todo 如何从jwt中解析出user信息
     * @param userId
     * @return
     */
//    @GetMapping("/my_message")
//    public CommonResult getMyMessage(@CurrentUser User user){
//        log.info("userId={}, username={}", user.getUserId(),user.getNickname());
//
//
//    }

}

