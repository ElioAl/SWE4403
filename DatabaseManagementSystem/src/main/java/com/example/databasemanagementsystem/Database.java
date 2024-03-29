package com.example.databasemanagementsystem;

import SharedDataTypes.Order;
import SharedDataTypes.Product;
import SharedDataTypes.User;

import java.util.ArrayList;

public interface Database {
    void add_user(String username, String password, String type);

    void delete_user(String username, String password) throws UnauthorizedAccessException;
    User get_User(int user_ID);

    void getUserIDForAuthority(User loggedIn);

    void add_product(String name, double cost, int quantity, String category) throws UnauthorizedAccessException;

    void get_product(int product_ID);

    void update_product(Product toUpdate) throws UnauthorizedAccessException; //not implemented

    Product delete_product(int product_ID) throws UnauthorizedAccessException; //not implemented

    ArrayList<Product> getCategory(String category);

    void setProductQuantity(int product_ID, int quantity) throws UnauthorizedAccessException;

    void placeOrder(int order_ID, ArrayList<Product> order);

    boolean cancelOrder(Order toCancel) throws UnauthorizedAccessException;
}
