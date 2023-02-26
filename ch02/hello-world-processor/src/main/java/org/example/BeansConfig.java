package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean(initMethod = "initMethod")
    public Hello hello() {
        return new Hello();
    }

    @Bean
    public HelloBeanPostProcessor helloBeanPostProcessor() {
        return new HelloBeanPostProcessor();
    }

    @Bean
    public HelloBeanPostProcessor2 helloBeanPostProcessor2() {
        return new HelloBeanPostProcessor2();
    }

    @Bean
    public static BeanFactoryPostProcessorImpl beanFactoryPostProcessorImpl() {
        return new BeanFactoryPostProcessorImpl();
    }
}
