package org.example.propertysource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan
@PropertySource(
        value = {"classpath:application.properties", "classpath:wrong.properties"},
        ignoreResourceNotFound = true)
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Application.class);
        Hello hello = annotationConfigApplicationContext.getBean(Hello.class);
        hello.hello();
        Hello2 hello2 = annotationConfigApplicationContext.getBean(Hello2.class);
        hello2.hello();

        /*
            foo.bar = test
            foo.bar = test
            foo.tar = default foo.tar value
            user language = zh
            java version = 11.0.17
        */

    }
}
