package com.du.feheadstudio.security;

import com.du.feheadstudio.entity.CurrentUser;
import com.du.feheadstudio.entity.User;
import com.du.feheadstudio.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Author DU425
 * @Date 2022/3/9 19:56
 * @Version 1.0
 * @Description
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class) &&
                parameter.getParameterType().isAssignableFrom(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = webRequest.getHeader("token");
        String userId = jwtTokenUtil.getUsername(token);
        return userMapper.selectById(userId);
    }
}
