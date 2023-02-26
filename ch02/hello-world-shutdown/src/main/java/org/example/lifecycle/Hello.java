package org.example.lifecycle;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

@Component
public class Hello implements Lifecycle {
    private boolean flag = false;

    public String hello() {
        return flag ? "Hello World!" : "Bye!";
    }

    @Override
    public void start() {
        System.out.println("Context Started.");
        flag = true;
    }

    @Override
    public void stop() {
        System.out.println("Context Stopped.");
        flag = false;
    }

    @Override
    public boolean isRunning() {
        return flag;
    }
}
