package com.bakanna.assurance.service.develop.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

public interface SecurityConfigurer {
    DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception;

    void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception;
}

