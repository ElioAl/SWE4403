package unb.microservices.orderservice;

import java.util.ArrayList;

public class Order {
    private String userId;
    private ArrayList<String> items;
    private String date;

    public Order(String id, ArrayList<String> itm, String dt){
        userId = id;
        items = itm;
        date = dt;
    }

    public Order() {

    }

    public String getUserId() {
        return userId;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
