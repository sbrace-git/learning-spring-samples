package org.example.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@EnableAsync
@Component
public class Hello {

    @Async
    public void hello() {
        System.out.println("hello async");
    }
}
