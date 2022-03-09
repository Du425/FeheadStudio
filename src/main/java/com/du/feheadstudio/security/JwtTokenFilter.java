package com.du.feheadstudio.security;

import com.du.feheadstudio.handler.CustomizeAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author DU425
 * @Date 2022/3/6 17:02
 * @Version 1.0
 * @Description
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtTokenUtil.resolveToken(request);
        try {
            if (token != null && jwtTokenUtil.validateToken(token)){
                Authentication authentication = jwtTokenUtil.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (CustomizeAuthenticationFailureHandler customizeAuthenticationFailureHandler) {
            customizeAuthenticationFailureHandler.printStackTrace();
        }

        String token1 = request.getHeader("token");



        filterChain.doFilter(request,response);
    }

}
