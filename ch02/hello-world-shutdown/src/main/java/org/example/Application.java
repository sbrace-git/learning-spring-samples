package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
        applicationContext.start();
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.hello());
        applicationContext.close();
        System.out.println(hello.hello());
    }
}
