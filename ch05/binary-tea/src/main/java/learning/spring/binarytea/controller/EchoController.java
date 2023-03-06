package learning.spring.binarytea.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/echo")
public class EchoController {

    private final RestTemplate restTemplate;


    public EchoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @Timed(extraTags = {"region", "cn-shanghai-1"}, percentiles = 0.99D)
    public String echo(String echo) {
        return echo;
    }

    @GetMapping("/restTemplate")
    public String restTemplate(String echo) {
        return restTemplate.getForObject("http://localhost:8080/echo?echo=hello", String.class);
    }

    @GetMapping("/sleep")
    public String sleep(String echo) throws InterruptedException {
        Thread.sleep(8000L);
        return echo(echo);
    }

}
