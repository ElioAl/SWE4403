package unb.microservices.orderservice;

import java.util.ArrayList;

public class OrderCommandExecutor {
    private ArrayList<String> log;
    private ArrayList<Command> queue;

    private Order order;

    public void createOrder(int id){
        order = new Order(id, new ArrayList<Product>());
        Command.setCurrentOrder(order);
    }

    public void addToOrder(Product item){
        Command addToOrder = new AddToOrderCommand();
        addToOrder.setItem(item);
        addToOrder.execute();
        log.add("Added " + item.getName());
        queue.add(addToOrder);
    }

    public void removeFromOrder(Product item){
        Command removeFromOrder = new RemoveFromOrderCommand();
        removeFromOrder.setItem(item);
        removeFromOrder.execute();
        log.add("Removed " + item.getName());
        queue.add(removeFromOrder);
    }

    public void placeOrder(){
        Command placeOrder = new PlaceOrderCommand();
        placeOrder.execute();
        log.add("Placed Order ");
        queue.add(placeOrder);
    }

    public void cancelOrder(){
        Command cancelOrder = new CancelOrderCommand();
        cancelOrder.execute();
        log.add("Cancelled Order ");
        queue.add(cancelOrder);
    }

    public void undo(){
        int len = queue.size();
        log.add("Undid last action");
        queue.get(len-1).undo();
        queue.remove(len-1);
    }

    public void showCart(){
        for (Product item: Command.getOrder().getItems()) {
            System.out.println(item.getName() + " : " + item.getCost());
        }
    }

}
