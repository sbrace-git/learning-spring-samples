package org.example.costomevent;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object source) {
        super(source);
    }
}
