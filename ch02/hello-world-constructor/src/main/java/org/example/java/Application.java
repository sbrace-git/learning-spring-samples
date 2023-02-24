package org.example.java;

import org.example.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private final ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    public Application() {
        context = new AnnotationConfigApplicationContext(Config.class);
    }

    public static void main(String[] args) {
        ApplicationContext context = new Application().getContext();
        Hello bean = context.getBean(Hello.class);
        System.out.println(bean.hello());


        System.out.println("=====================================================");


        Foo foo = context.getBean(Foo.class);
        System.out.println(foo);
        Bar bar = context.getBean("bar", Bar.class);
        System.out.println(bar);
        Bar baz = context.getBean("baz", Bar.class);
        System.out.println(baz);

    }
}
