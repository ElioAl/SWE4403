package com.example.databasemanagementsystem;

public interface Database {
    public void add_user(String username, String password);

    public void delete_user(String username, String password);
}
