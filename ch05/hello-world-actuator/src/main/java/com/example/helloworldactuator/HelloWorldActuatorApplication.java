package com.example.helloworldactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorldActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldActuatorApplication.class, args);
    }

    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World! Bravo Spring!";
    }
}
