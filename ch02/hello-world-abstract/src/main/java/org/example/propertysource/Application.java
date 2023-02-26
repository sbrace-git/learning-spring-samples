package org.example.propertysource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource("classpath:application.properties")
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Application.class);
        Hello hello = annotationConfigApplicationContext.getBean(Hello.class);
        hello.hello();
        Hello2 hello2 = annotationConfigApplicationContext.getBean(Hello2.class);
        hello2.hello();

        /*
            foo.bar = test
            foo.bar = foo.bar
            foo.tar = default foo.tar value
        */

    }
}
