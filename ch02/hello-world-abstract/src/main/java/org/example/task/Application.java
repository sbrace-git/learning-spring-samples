package org.example.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@ComponentScan
@ImportResource("classpath:beans.xml")
public class Application {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Application.class);
        ThreadPoolTaskExecutor taskExecutor = annotationConfigApplicationContext.getBean("taskExecutor", ThreadPoolTaskExecutor.class);
        System.out.println("run 1");
        taskExecutor.execute(() -> System.out.println("run"));
        System.out.println("run 2");

        Thread.sleep(3000L);
        System.out.println("=======================================");

        Hello hello = annotationConfigApplicationContext.getBean("hello", Hello.class);
        System.out.println("hello 1");
        hello.hello();
        System.out.println("hello 2");
        annotationConfigApplicationContext.close();

        /*

            run 1
            run 2
            run
            =======================================
            hello 1
            hello 2
            hello async

         */
    }

}
