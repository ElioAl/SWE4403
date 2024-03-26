package unb.microservices.orderservice;

public class AddOrderCommand extends Command{
    @Override
    public void execute(Order e) {
        Command.getOrders().add(e);
        log.add(e);
    }

    @Override
    public void undo() {
        int length = Command.getOrders().size();
        Command.getOrders().remove(length -1);
    }
}
