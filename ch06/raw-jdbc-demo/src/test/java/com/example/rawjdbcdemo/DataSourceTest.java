package com.example.rawjdbcdemo;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariProxyConnection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class DataSourceTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * need dependency spring-boot-starter-jdbc
     */
    @Test
    void testDataSource() throws SQLException {
        assertTrue(applicationContext.containsBean("dataSource"));
        DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
        assertTrue(dataSource instanceof HikariDataSource);
        Connection connection = dataSource.getConnection();
        assertTrue(connection instanceof HikariProxyConnection);
        connection.close();
        assertEquals(10, ((HikariDataSource) dataSource).getMaximumPoolSize());
    }


}
