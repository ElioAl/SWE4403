package unb.microservices.orderservice;

public class PlaceOrderCommand extends Command{
    @Override
    public void setItem(String item) {

    }

    @Override
    public void execute() {
        //transfer to payement
    }

    @Override
    public void undo() {
        Command cancelCommand = new CancelOrderCommand();
        cancelCommand.execute();
    }
}
