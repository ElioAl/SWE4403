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

    @Override
    public void add_product(String name, double cost, int quantity){
        product_DB.add_product(name, cost, quantity);
    }

    @Override
    public void get_product(int product_ID){
        product_DB.get_product(product_ID);
    }

    @Override
    public void setProductQuantity(int product_ID, int quantity) {
        product_DB.setProductQuantity(product_ID ,quantity);
    }
}
