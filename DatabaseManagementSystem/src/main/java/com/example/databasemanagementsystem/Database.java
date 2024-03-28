package com.example.databasemanagementsystem;

import java.util.ArrayList;

public interface Database {
    void add_user(String username, String password);

    void delete_user(String username, String password);
    ArrayList<String> get_User(int user_ID);

    void add_product(String name, double cost, int quantity);

    void get_product(int product_ID);

    void setProductQuantity(int product_ID, int quantity);
}
