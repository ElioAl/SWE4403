package com.example.databasemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseManagementSystemApplication.class, args);
        System.out.println("ITS WORKING MFS");
        //DB_Connection.main(null);
    }

}
