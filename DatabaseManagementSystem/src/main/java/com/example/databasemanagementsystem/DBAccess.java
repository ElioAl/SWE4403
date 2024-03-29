package com.example.databasemanagementsystem;

import SharedDataTypes.Product;

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
    public void update_product(Product toUpdate) {
        product_DB.updateProduct(toUpdate);
    }

    @Override
    public Product delete_product(int product_ID) {
        return product_DB.deleteProduct(product_ID);
    }

    @Override
    public void setProductQuantity(int product_ID, int quantity) {
        product_DB.setProductQuantity(product_ID ,quantity);
    }

    @Override
    public void placeOrder(int user_ID, ArrayList<Product> order) {
        int order_ID = order_DB.addOrder(user_ID);
        for(Product x: order){
            order_DB.addToOrder(order_ID, user_ID, x);
        }
    }

    @Override
    public boolean cancelOrder(int order_ID){
        String toCheck = order_tracking_DB.getOrder(order_ID);
        return toCheck.equals("NotPlaced") || toCheck.equals("Processing");
    }
}
