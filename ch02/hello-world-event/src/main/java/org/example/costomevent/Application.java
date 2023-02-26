package org.example.costomevent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Application.class);
        applicationContext.getBean(CustomEventPublisher.class).fire();
        applicationContext.close();
    }
}
