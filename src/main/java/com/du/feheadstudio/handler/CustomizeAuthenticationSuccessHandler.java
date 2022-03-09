package com.du.feheadstudio.handler;

import com.alibaba.fastjson.JSON;
import com.du.feheadstudio.controller.UserController;
import com.du.feheadstudio.response.CommonResult;
import com.du.feheadstudio.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author DU425
 * @Date 2022/1/16 14:50
 * @Version 1.0
 */
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    UserController userController;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String username = (String) authentication.getPrincipal();
            String token = jwtTokenUtil.generateToken(username);
        CommonResult result = CommonResult.success("登陆成功", token);
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
