package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class HelloApplication {

    private final BeanFactory beanFactory;

    public HelloApplication() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        beanFactory = defaultListableBeanFactory;
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("beans.xml");
    }

    public static void main(String[] args) {
        HelloApplication helloApplication = new HelloApplication();
        helloApplication.sayHello();
    }


    public void sayHello() {
        Object helloObject = beanFactory.getBean("hello");
        System.out.println(helloObject.getClass());
        System.out.println(((Hello) helloObject).hello());

        Hello hello = beanFactory.getBean("hello", Hello.class);

        System.out.printf("helloObject == hello : %b%n", helloObject == hello);
        System.out.println(hello.hello());
    }

}
