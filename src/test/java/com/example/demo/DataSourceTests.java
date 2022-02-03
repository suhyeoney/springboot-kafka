package com.example.demo;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class DataSourceTests {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testConnection() {
        try {
            Connection connection = dataSource.getConnection();
            log.info("Meta Data : " + connection.getMetaData());
            log.info("Driver Name : " + connection.getMetaData().getDriverName());
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
