package unb.microservices.orderservice;

public class RemoveOrderCommand extends Command{
    @Override
    public void execute(Order e) {
        log.add(e);
        Command.getOrders().remove(e);

    }

    @Override
    public void undo() {
        int len = log.size();
        Command.getOrders().add(log.get(len-1));
    }
}
