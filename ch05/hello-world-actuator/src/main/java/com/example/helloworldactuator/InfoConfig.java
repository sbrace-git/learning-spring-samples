package com.example.helloworldactuator;

import org.springframework.boot.actuate.info.SimpleInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfoConfig {
    @Bean
    public SimpleInfoContributor simpleInfoContributor() {
        return new SimpleInfoContributor("simple", "HelloWorld!");
    }

}
