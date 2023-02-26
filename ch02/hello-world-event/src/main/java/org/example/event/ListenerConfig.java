package org.example.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerConfig {

    @EventListener
    public void stop(ContextStoppedEvent contextStoppedEvent) {
        System.out.println("[@EventListener] ApplicationContext stopped.");
    }

    @EventListener
    public void start(ContextStartedEvent contextStartedEvent) {
        System.out.println("[@EventListener] ApplicationContext started.");
    }

    @EventListener
    public void refresh(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("[@EventListener] ApplicationContext refreshed.");
    }
}
