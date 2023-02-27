package org.example.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(Application.class);
        System.out.println("================================================");
        applicationContext.refresh();
        System.out.println("================================================");
        applicationContext.stop();
        System.out.println("================================================");
        applicationContext.start();
        System.out.println("================================================");
        applicationContext.close();

        /*

        ================================================
        [@EventListener] ApplicationContext refreshed.
        ================================================
        [@EventListener] ApplicationContext stopped.
        ================================================
        [@EventListener] ApplicationContext started.
        ================================================
        [ContextClosedEventListener] ApplicationContext closed.
        [@EventListener] ApplicationContext closed.

        */
    }
}
