package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FileSystemMain {
    private final ApplicationContext applicationContext;

    public FileSystemMain() {
        applicationContext = new FileSystemXmlApplicationContext("classpath:beans.xml");
    }

    private void sayHello() {
        Hello hello = applicationContext.getBean("hello", Hello.class);
        System.out.println(hello.hello());
    }

    public static void main(String[] args) {
        FileSystemMain fileSystemMain = new FileSystemMain();
        fileSystemMain.sayHello();
    }
}
