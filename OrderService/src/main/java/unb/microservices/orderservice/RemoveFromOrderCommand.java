package unb.microservices.orderservice;

public class RemoveFromOrderCommand extends Command{
    private String item;
    @Override
    public void execute() {
        Command.getOrder().getItems().remove(item);
        //add db method
    }

    @Override
    public void undo() {
        Command.getOrder().getItems().add(item);
    }

    public void setItem(String item) {
        this.item = item;
    }
}
