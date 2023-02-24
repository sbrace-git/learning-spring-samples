package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloBox {

    private final ClassPathXmlApplicationContext context;

    public TestHelloBox() {
        this.context = new ClassPathXmlApplicationContext("box-beans.xml");
    }

    public ClassPathXmlApplicationContext getContext() {
        return context;
    }

    public static void main(String[] args) {

        TestHelloBox testHelloBox = new TestHelloBox();
        ClassPathXmlApplicationContext context = testHelloBox.getContext();
        Hello hello = context.getBean(Hello.class);
        System.out.println(hello.hello());

        System.out.println("=====================================================");

        HelloBox helloBox = context.getBean(HelloBox.class);
        System.out.println(helloBox);


    }

}
