package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private final ClassPathXmlApplicationContext parentContext;
    private final ClassPathXmlApplicationContext childContext;

    public Main() {
        parentContext = new ClassPathXmlApplicationContext("parent-beans.xml");
        childContext = new ClassPathXmlApplicationContext(
                new String[]{"child-beans.xml"}, true, parentContext);
        parentContext.setId("ParentContext");
        childContext.setId("ChildContext");
    }

    public static void main(String[] args) {
        new Main().runTests();
    }

    public void runTests() {
        testVisibility(parentContext, "parentHello");
        testVisibility(childContext, "parentHello");
        testVisibility(parentContext, "childHello");
        testVisibility(childContext, "childHello");
        testOverridden(parentContext, "hello");
        testOverridden(childContext, "hello");
    }

    private void testVisibility(ApplicationContext context, String beanName) {
        System.out.println(context.getId() + " can see " + beanName + ": "
                + context.containsBean(beanName));
    }

    private void testOverridden(ApplicationContext context, String beanName) {
        System.out.println("sayHello from " + context.getId() + ": "
                + context.getBean(beanName, Hello.class).hello());
    }
}