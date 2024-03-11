package com.example.databasemanagementsystem;

import java.util.ArrayList;

public class DBAccess implements Database{

    @Override
    public void add_user(String username, String password) {
        user_DB.add_user(username, password);
    }

    @Override
    public void delete_user(String username, String password) {
        user_DB.delete_user(username, password);
    }

    @Override
    public ArrayList<String> get_User(int user_ID) {
        return user_DB.get_user(user_ID);
    }
}
