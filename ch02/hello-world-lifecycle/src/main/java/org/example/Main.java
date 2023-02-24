package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private final ClassPathXmlApplicationContext applicationContext;

    public Main() {
        applicationContext = new ClassPathXmlApplicationContext("beans.xml");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.sayHello();
        main.close();

        /*
            postConstruct()
            afterPropertiesSet()
            init()
            Hello World!
            ========== application close() start ==========
            preDestroy()
            destroy()
            close()
            ========== application close() end ============
         */

    }

    public void sayHello() {
        Hello hello = applicationContext.getBean(Hello.class);
        System.out.println(hello.hello());
    }

    public void close() {
        System.out.println("========== application close() start ==========");
        applicationContext.close();
        System.out.println("========== application close() end ============");
    }
}