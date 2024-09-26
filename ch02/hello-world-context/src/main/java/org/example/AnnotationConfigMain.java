package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConfigMain {
    private final ApplicationContext applicationContext;

    public AnnotationConfigMain() {
        applicationContext = new AnnotationConfigApplicationContext("org.example");
    }

    private void sayHello() {
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.hello());
    }

    public static void main(String[] args) {
        AnnotationConfigMain annotationConfigMain = new AnnotationConfigMain();
        annotationConfigMain.sayHello();
    }
}
