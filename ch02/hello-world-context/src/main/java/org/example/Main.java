package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private final ApplicationContext applicationContext;

    public Main() {
        this.applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.sayHello();
    }

    public void sayHello() {
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.hello());
    }
}