package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Main.class);
        Hello hello = applicationContext.getBean(Hello.class);
        System.out.println(hello.sayHello(new StringBuffer("world! A")));
//        System.out.println(hello.sayHello(new StringBuffer("world! B")));
        /*
            @Around start.
            @Before - 1
            @Before - 2
            @Before - 3
            @AfterReturning Say something: world! Welcome to Spring!
            @After after
            @Around end. Total time: 5ms
            Hello! world! Welcome to Spring!
         */
    }
}