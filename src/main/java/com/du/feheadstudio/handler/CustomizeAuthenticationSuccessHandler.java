package com.du.feheadstudio.handler;

import com.du.feheadstudio.controller.UserController;
import com.du.feheadstudio.response.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

//        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        //todo 类型转换
//        CommonResult sysUser = userController.selectByUserId(userDetails.getUsername());

    }
}
