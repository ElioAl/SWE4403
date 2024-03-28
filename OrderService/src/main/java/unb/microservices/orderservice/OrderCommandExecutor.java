package unb.microservices.orderservice;

import java.util.ArrayList;

public class OrderCommandExecutor {
    private ArrayList<String> log;
    private ArrayList<Command> queue;

    private Order order;

    public void createOrder(String id){
        order = new Order(id, new ArrayList<String>(), "");
        Command.setCurrentOrder(order);
    }

    public void addToOrder(String item){
        Command addToOrder = new AddToOrderCommand();
        addToOrder.setItem(item);
        addToOrder.execute();
        log.add("Added " + item);
        queue.add(addToOrder);
    }

    public void removeFromOrder(String item){
        Command removeFromOrder = new RemoveFromOrderCommand();
        removeFromOrder.setItem(item);
        removeFromOrder.execute();
        log.add("Removed " + item);
        queue.add(removeFromOrder);
    }

    public void placeOrder(){
        Command placeOrder = new PlaceOrderCommand();
        placeOrder.execute();
        log.add("Placed Order " + Command.getOrder().getOrderId());
        queue.add(placeOrder);
    }

    public void cancelOrder(){
        Command cancelOrder = new CancelOrderCommand();
        cancelOrder.execute();
        log.add("Cancelled Order " + Command.getOrder().getOrderId());
        queue.add(cancelOrder);
    }

    public void undo(){
        int len = queue.size();
        log.add("Undid last action");
        queue.get(len-1).undo();
        queue.remove(len-1);
    }

}
