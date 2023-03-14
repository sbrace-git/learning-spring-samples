package com.example.mysqldatasource;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class MysqlDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlDatasourceApplication.class, args);
    }

    @Bean("dataSource")
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource getDataSource(DataSourceProperties dataSourceProperties) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(dataSourceProperties.getUrl());
        hikariDataSource.setUsername(dataSourceProperties.getUsername());
        hikariDataSource.setPassword(dataSourceProperties.getPassword());
        hikariDataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return hikariDataSource;
    }
}
