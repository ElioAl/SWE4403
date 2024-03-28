package unb.microservices.orderservice;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private ArrayList<String> items;
    private String date;

    public Order(String id, ArrayList<String> itm, String dt){
        orderId = id;
        items = itm;
        date = dt;
    }

    public Order() {

    }

    public String getOrderId() {
        return orderId;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
