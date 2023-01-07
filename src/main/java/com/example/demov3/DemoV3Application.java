package com.example.demov3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class DemoV3Application implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(DemoV3Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Fetching from database with the Driver, eponing connection");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/v3demo", "root", "asdasd");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from person");
        while (rs.next()) {
            System.out.println("id:" + rs.getInt(1) + " ,username: " + rs.getString(2) + "  ");
        }

        // Run this if you need at least one entry
//        stmt.execute("INSERT INTO person (id, username) VALUES (1, 'Some username')");
        con.close();

        System.out.println("Fetching from database with the Driver ended, closing driver");
    }
}
