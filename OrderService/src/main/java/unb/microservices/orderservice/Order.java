package unb.microservices.orderservice;

import java.util.ArrayList;

public class Order {
    private String userId;
    private ArrayList<Product> items;

    public Order(String id, ArrayList<Product> itm){
        userId = id;
        items = itm;
    }

    public Order() {

    }

    public String getUserId() {
        return userId;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }
}
