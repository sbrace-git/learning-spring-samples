package org.example.event;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class ContextClosedEventAnnotationListener {

    @Order(2)
    @EventListener
    public void onEvent(ContextClosedEvent contextClosedEvent) {
        System.out.println("[@EventListener] ApplicationContext closed.");
    }

}
