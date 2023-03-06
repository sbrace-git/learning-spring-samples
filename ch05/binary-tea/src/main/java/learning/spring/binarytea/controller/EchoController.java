package learning.spring.binarytea.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    @GetMapping
    @Timed(extraTags = {"region", "cn-shanghai-1"}, percentiles = 0.99D)
    public String echo(String echo) {
        return echo;
    }
}
