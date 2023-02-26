package org.example.profile;

import org.springframework.context.annotation.*;

@Configuration
@ImportResource(value = {"classpath:beans-dev.xml", "classpath:beans-prod.xml"})
public class Application2 {
    public static void main(String[] args) {
        /*
         * environment variables
         * spring.profiles.active=dev
         * spring.profiles.active=prod
         */
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();annotationConfigApplicationContext.register(Application2.class);
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
