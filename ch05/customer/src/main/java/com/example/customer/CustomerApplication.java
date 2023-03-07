package com.example.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
@SpringBootApplication
public class CustomerApplication {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }


    /*
        --wait=3,--key=value,Hello
    */

    @Bean
    public CommandLineRunner run() {
        // 共传入了3个参数。分别是--wait=3,--key=value,Hello
        return args -> log.info("共传入了{}个参数。分别是{}",
                args.length, StringUtils.arrayToCommaDelimitedString(args));
    }

    /*
            还没开门，先等3秒
            其他参数:Hello
    */

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            boolean needWait = args.containsOption("wait");
            if (!needWait) {
                log.info("如果门没开就不用等了");
            } else {
                List<String> waitSeconds = args.getOptionValues("wait");
                if (!waitSeconds.isEmpty()) {
                    Integer seconds = NumberUtils.parseNumber(waitSeconds.get(0), Integer.class);
                    log.info("还没开门，先等{}秒", seconds);
                    Thread.sleep(seconds * 1000);
                }
            }
            log.info("其他参数:{}", StringUtils.collectionToCommaDelimitedString(args.getNonOptionArgs()));
            System.exit(SpringApplication.exit(applicationContext));
        };
    }

    @Bean
    public ExitCodeGenerator exitCodeGenerator(ApplicationArguments arguments) {
        return () -> (arguments.containsOption("wait") ? 0 : 1);
    }
}
