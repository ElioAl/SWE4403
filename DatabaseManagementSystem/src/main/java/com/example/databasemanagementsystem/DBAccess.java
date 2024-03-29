package com.example.databasemanagementsystem;

import SharedDataTypes.*;

import java.util.ArrayList;

public class DBAccess implements Database{

    @Override
    public void add_user(String username, String password, String type) {
        user_DB.add_user(username, password, type);
    }

    @Override
    public void delete_user(String username, String password) throws UnauthorizedAccessException {
        if(DB_Connection.getAuthority("customer") == 200 &&
                DB_Connection.UserLoggedIn.getUsername().equals(username) &&
                DB_Connection.UserLoggedIn.getPassword().equals(password)) {
            user_DB.delete_user(username, password);
        } else {
            throw new UnauthorizedAccessException("Unauthorized access to delete user");
        }
    }

    @Override
    public User get_User(int user_ID) {
        return user_DB.get_user(user_ID);
    }

    @Override
    public void getUserForAuthority(User loggedIn) {
        DB_Connection.setAuthority(loggedIn);
    }

    @Override
    public void add_product(String name, double cost, int quantity, String category) throws UnauthorizedAccessException {
        if(DB_Connection.getAuthority("retailer") == 200) {
            product_DB.add_product(name, cost, quantity, category);
        } else {
            throw new UnauthorizedAccessException("Unauthorized Access for adding product");
        }
    }

    @Override
    public void get_product(int product_ID){
        product_DB.get_product(product_ID);
    }

    @Override
    public void update_product(Product toUpdate) throws UnauthorizedAccessException {
        if(DB_Connection.getAuthority("retailer") == 200) {
            product_DB.updateProduct(toUpdate);
        } else {
            throw new UnauthorizedAccessException("Unauthorized access to update product");
        }
    }

    @Override
    public Product delete_product(int product_ID) throws UnauthorizedAccessException {
        if (DB_Connection.getAuthority("retailer") == 200) {
            return product_DB.deleteProduct(product_ID);
        } else {
            throw new UnauthorizedAccessException("Unauthorized access to delete product");
        }
    }

    @Override
    public ArrayList<Product> getCategory(String category) {
        return product_DB.getCategory(category);
    }

    @Override
    public void setProductQuantity(int product_ID, int quantity) throws UnauthorizedAccessException {
        if(DB_Connection.getAuthority("retailer") == 200) {
            product_DB.setProductQuantity(product_ID, quantity);
        } else {
            throw new UnauthorizedAccessException("Unauthorized access to set quantity");
        }
    }

    @Override
    public void placeOrder(int user_ID, ArrayList<Product> order) {
        if(user_ID == DB_Connection.UserLoggedIn.getUser_ID()) {
            int order_ID = order_DB.addOrder(user_ID);
            for (Product x : order) {
                order_DB.addToOrder(order_ID, user_ID, x);
            }
        }
    }

    @Override
    public boolean cancelOrder(Order toCancel) throws UnauthorizedAccessException {
        if (toCancel.getOrder_ID() == DB_Connection.UserLoggedIn.getUser_ID()) {
            String toCheck = order_tracking_DB.getOrder(toCancel.getOrder_ID());
            return toCheck.equals("NotPlaced") || toCheck.equals("Processing");
        } else {
            throw new UnauthorizedAccessException("Unauthorized access to cancel order");
        }
    }
}
