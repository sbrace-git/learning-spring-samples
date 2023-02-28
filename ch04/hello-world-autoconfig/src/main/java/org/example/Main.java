package org.example;

import org.speaker.Speaker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource(value = "classpath:application.properties")
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Main.class);
        Speaker speaker = annotationConfigApplicationContext.getBean("speaker", Speaker.class);
        System.out.println(speaker.speak());
    }
}