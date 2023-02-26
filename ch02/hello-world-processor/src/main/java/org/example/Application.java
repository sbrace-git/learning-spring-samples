package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Application.class);
        applicationContext.close();

        /*

            Hello Construct
            Hello postProcessBeforeInitialization - 1
            Hello postProcessBeforeInitialization - 2
            Hello PostConstruct
            Hello initMethod
            Hello postProcessAfterInitialization - 1
            Hello postProcessAfterInitialization - 2

        * */
    }
}
