package unb.microservices.orderservice;

import java.util.ArrayList;

public class CancelOrderCommand extends Command{

    @Override
    public void setItem(Product item) {

    }

    @Override
    public void execute() {
        Command.setCurrentOrder(new Order());
        //add database method
    }

    @Override
    public void undo() {
        Command placeOrderCommand = new PlaceOrderCommand();
        placeOrderCommand.execute();
    }
}
