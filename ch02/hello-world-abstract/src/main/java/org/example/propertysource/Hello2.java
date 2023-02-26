package org.example.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Hello2 {
    @Value("foo.bar")
    private String fooBar;

    @Value("${foo.tar:default foo.tar value}")
    private String fooTar;

    public void hello() {
        System.out.println("foo.bar = " + fooBar);
        System.out.println("foo.tar = " + fooTar);
    }
}
