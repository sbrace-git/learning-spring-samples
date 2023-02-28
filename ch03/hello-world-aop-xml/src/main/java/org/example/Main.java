package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("application.xml");
        Hello hello = classPathXmlApplicationContext.getBean(Hello.class);
        System.out.println(hello.sayHello(new StringBuffer("world! A")));

        /*
            SayMethodInterceptor
            @Around start. - 1
            @Around start. - 2
            @Before - 1
            @Before - 2
            @Before - 3
            @Around end. Total time: 4ms - 2
            Bye!  @Around - 2
            @Around end. Total time: 8ms - 1
            @AfterReturning param: world! A around change - 1! around change - 2! Bye! 1 Welcome to Spring!
            @AfterReturning returning: Hello! world! A around change - 1! around change - 2! Bye! 1 Welcome to Spring!
            @After after - 1
            @After after - 2
            Hello! world! A around change - 1! around change - 2! Bye! 1 Welcome to Spring!
        */
    }
}