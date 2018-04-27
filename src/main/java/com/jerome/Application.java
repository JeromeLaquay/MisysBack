package com.jerome;

import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    DataSource dataSource;
    

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Transactional(readOnly = true)
    @Override
    public void run(String... args) throws Exception {
        System.out.println("DATASOURCE = " + dataSource);
    }

}