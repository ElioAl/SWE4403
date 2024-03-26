package unb.microservices.orderservice;

import java.util.ArrayList;

public class CancelOrderCommand extends Command{
    @Override
    public void execute(Order e) {
        temp = Command.getOrders();
        Command.setCurrentOrders(new ArrayList<Order>());
    }

    @Override
    public void undo() {
        Command.setCurrentOrders(temp);
    }
}
