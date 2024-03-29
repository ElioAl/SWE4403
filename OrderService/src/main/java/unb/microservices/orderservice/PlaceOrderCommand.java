package unb.microservices.orderservice;

public class PlaceOrderCommand extends Command{

    @Override
    public void setItem(Product item) {

    }

    @Override
    public void execute() {
        //transfer to payment
    }

    @Override
    public void undo() {
        Command cancelCommand = new CancelOrderCommand();
        cancelCommand.execute();
    }
}
