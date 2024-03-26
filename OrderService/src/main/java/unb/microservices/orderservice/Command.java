package unb.microservices.orderservice;

import java.util.ArrayList;

public abstract class Command {
    private static ArrayList<Order> orders;
    public static ArrayList<Order> log;
    public static ArrayList<Order> temp;

    public static void setCurrentOrders(ArrayList<Order> currentOrders) {
        orders = currentOrders;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public abstract void execute(Order e);
    public abstract void undo();
}
