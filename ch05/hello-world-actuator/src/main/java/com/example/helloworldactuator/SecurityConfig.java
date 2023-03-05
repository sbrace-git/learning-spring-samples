package com.example.helloworldactuator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
    private final Logger logger = LogManager.getLogger();

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("securityFilterChain");
        http.authorizeRequests()
                // 保护 env 端点，登录后才可以访问
                .requestMatchers(EndpointRequest.to("env")).authenticated()
                // beans 仅可以匿名访问，登录后不可以访问
                .requestMatchers(EndpointRequest.to("beans")).anonymous()
                // 其他端点是否登录都可以访问
                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
                .and()
                // 登录页面 http://localhost:8081/management/login
                .formLogin();
        return http.build();
    }

}
