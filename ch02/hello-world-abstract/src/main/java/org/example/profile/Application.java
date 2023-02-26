package org.example.profile;

import org.springframework.context.annotation.*;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
@ImportResource(value = {"classpath:beans.xml", "classpath:beans-prod.xml"})
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        environment.setActiveProfiles("dev");
//        environment.setActiveProfiles("prod");
        annotationConfigApplicationContext.register(Application.class);
        annotationConfigApplicationContext.refresh();
        Hello hello = annotationConfigApplicationContext.getBean("hello-1", Hello.class);
        hello.hello();
        Hello hello2 = annotationConfigApplicationContext.getBean("hello-2", Hello.class);
        hello2.hello();
    }

    @Profile("dev")
    @Bean("hello-2")
    public Hello helloDev2() {
        return new Hello("hello-2 dev");
    }

    @Profile("prod")
    @Bean("hello-2")
    public Hello helloProd2() {
        return new Hello("hello-2 prod");
    }
}
