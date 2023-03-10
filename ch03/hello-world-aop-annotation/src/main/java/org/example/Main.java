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
            @Around start. - 1
            @Around start. - 2
            @Before - 1
            @Before - 2
            @Before - 3
            @AfterReturning param: world! A around change - 1! around change - 2! Bye! 1 Welcome to Spring!
            @AfterReturning returning: Hello! world! A around change - 1! around change - 2! Bye! 1 Welcome to Spring!
            @After after - 2
            @After after - 1
            @Around end. Total time: 4ms - 2
            Bye!  @Around - 2
            @Around end. Total time: 9ms - 1
            Hello! world! A around change - 1! around change - 2! Bye! 1 Welcome to Spring!
         */
    }
}