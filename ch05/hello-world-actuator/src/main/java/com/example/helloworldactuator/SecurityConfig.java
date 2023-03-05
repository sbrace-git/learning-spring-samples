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
                .requestMatchers(EndpointRequest.to("env")).authenticated()
                .requestMatchers(EndpointRequest.toAnyEndpoint()).anonymous()
                .and()
                .formLogin();
        return http.build();
    }

}
