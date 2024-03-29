package com.example.databasemanagementsystem;

import SharedDataTypes.Product;

import java.util.ArrayList;

public interface Database {
    void add_user(String username, String password);

    void delete_user(String username, String password);
    ArrayList<String> get_User(int user_ID);

    void add_product(String name, double cost, int quantity, String category);

    void get_product(int product_ID);

    void update_product(Product toUpdate); //not implemented

    Product delete_product(int product_ID); //not implemented

    ArrayList<Product> getCategory(String category);

    void setProductQuantity(int product_ID, int quantity);

    void placeOrder(int order_ID, ArrayList<Product> order);

    boolean cancelOrder(int order_ID);
}
