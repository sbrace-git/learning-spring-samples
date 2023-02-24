package org.example.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private final ClassPathXmlApplicationContext context;

    public Application() {
        context = new ClassPathXmlApplicationContext("annotation-beans.xml");
    }

    public ClassPathXmlApplicationContext getContext() {
        return context;
    }

    public static void main(String[] args) {
        Application application = new Application();
        ClassPathXmlApplicationContext context = application.getContext();
        AnnotationHello bean = context.getBean(AnnotationHello.class);
        System.out.println(bean.hello());
        System.out.println(bean.getHello().hello());
        System.out.println(bean.getValue());
        System.out.println(bean.getWrongValue());
    }
}
