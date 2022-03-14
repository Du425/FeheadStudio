package com.du.feheadstudio.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author DU425
 * @Date 2022/3/6 16:58
 * @Version 1.0
 * @Description
 */
@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SecurityContext context = SecurityContextHolder.getContext();
        return null;
    }
}
