package com.du.feheadstudio.config;

import com.du.feheadstudio.security.LoginUserHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author DU425
 * @Date 2022/3/9 20:05
 * @Version 1.0
 * @Description
 */
//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserHandlerMethodArgumentResolver);
    }
}
