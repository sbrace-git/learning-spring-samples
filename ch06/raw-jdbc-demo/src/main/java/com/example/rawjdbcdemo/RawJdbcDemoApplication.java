package com.example.rawjdbcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
@SpringBootApplication
public class RawJdbcDemoApplication {

    public static void main(String[] args) throws ClassNotFoundException {
        SpringApplication.run(RawJdbcDemoApplication.class, args);
    }


    /*
            取值:1
            取值:2
            取值:3
            取值:4
            取值:5
            取值:6
            取值:7
            取值:8
            取值:9
            取值:10
         */

    @Bean
    public CommandLineRunner testJdbc() {
        return (args) -> {
            Class.forName("org.h2.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test_db");
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("select x from system_range(1,10)");
                while (resultSet.next()) {
                    log.info("取值:{}", resultSet.getInt(1));
                }
            } catch (Exception e) {
                log.error("出错啦", e);
            }
        };
    }

}
