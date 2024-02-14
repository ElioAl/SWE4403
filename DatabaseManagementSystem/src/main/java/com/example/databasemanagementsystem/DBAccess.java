package com.example.databasemanagementsystem;

import java.sql.*;
import java.util.Properties;

public class DBAccess implements Database{


    @Override
    public void add_user(String username, String password) {
        user_DB.add_user(username, password);
    }

    @Override
    public void delete_user(String username, String password) {
        user_DB.delete_user(username, password);
    }
}
