package unb.microservices.orderservice;

import java.util.ArrayList;

public abstract class Command {
    private static Order order;

    public static void setCurrentOrder(Order currentOrder) {
        order = currentOrder;
    }

    public static Order getOrder() {
        return order;
    }

    public abstract void setItem(String item);

    public abstract void execute();
    public abstract void undo();
}
