package org.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHelloBox {

    private final ClassPathXmlApplicationContext context;

    public TestHelloBox() {
        this.context = new ClassPathXmlApplicationContext("box-beans.xml");
        System.out.println("load box-beans.xml up");
    }

    public ClassPathXmlApplicationContext getContext() {
        return context;
    }

    public static void main(String[] args) throws InterruptedException {

        TestHelloBox testHelloBox = new TestHelloBox();

        System.out.println("=====================================================");
        Thread.sleep(3000L);
        ClassPathXmlApplicationContext context = testHelloBox.getContext();
        Hello hello = context.getBean(Hello.class);
        System.out.println(hello.hello());


        System.out.println("=====================================================");
        Thread.sleep(3000L);
        HelloBox helloBox = context.getBean(HelloBox.class);
        System.out.println(helloBox);
    }

}
