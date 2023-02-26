package org.example.event;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Hello {
    private boolean flag = false;

    public String hello() {
        return flag ? "Hello World!" : "Bye!";
    }

    @EventListener
    public void start(ContextStartedEvent contextStartedEvent) {
        System.out.println("Context Started.");
        flag = true;
    }

    @EventListener
    public void stop(ContextClosedEvent contextClosedEvent) {
        System.out.println("Context Stopped.");
        flag = false;
    }

    public boolean isRunning() {
        return flag;
    }
}
