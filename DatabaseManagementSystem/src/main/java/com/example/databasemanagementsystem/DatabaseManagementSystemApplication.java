package com.example.databasemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseManagementSystemApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(DatabaseManagementSystemApplication.class, args);
            System.out.println("Starting Database Management System");
            //DB_Connection.main(null);
        }
        catch(Exception e){
            System.out.println("Error starting Database Management System");
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Database Management System Online");
    }
}
