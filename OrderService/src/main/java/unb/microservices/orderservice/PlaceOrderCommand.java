package unb.microservices.orderservice;

public class PlaceOrderCommand extends Command{
    @Override
    public void execute(Order e) {
        //transfer to payement
    }

    @Override
    public void undo() {

    }
}
