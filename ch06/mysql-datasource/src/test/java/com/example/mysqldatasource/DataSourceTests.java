package com.example.mysqldatasource;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DataSourceTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Test
    void testDataSource() throws SQLException {
        assertTrue(applicationContext.containsBean("dataSource"));
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        assertTrue(dataSource instanceof HikariDataSource);

        HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
        assertEquals(20,hikariDataSource.getMaximumPoolSize());
        assertEquals(10,hikariDataSource.getMinimumIdle());
        assertEquals("com.mysql.cj.jdbc.Driver",hikariDataSource.getDriverClassName());
        assertEquals(jdbcUrl,hikariDataSource.getJdbcUrl());
        Connection connection = hikariDataSource.getConnection();
        assertNotNull(connection);
        connection.close();
    }
}
