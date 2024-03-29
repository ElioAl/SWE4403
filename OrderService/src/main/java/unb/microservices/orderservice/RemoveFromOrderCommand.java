package unb.microservices.orderservice;

public class RemoveFromOrderCommand extends Command{
    private Product item;
    @Override
    public void execute() {
        Command.getOrder().getItems().remove(item);
    }

    @Override
    public void undo() {
        Command.getOrder().getItems().add(item);
    }

    public void setItem(Product item) {
        this.item = item;
    }
}
