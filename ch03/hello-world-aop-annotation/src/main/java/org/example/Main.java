package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Main.class);
        Hello hello = applicationContext.getBean(Hello.class);
        System.out.println(hello.sayHello(new StringBuffer("world")));
    }
}