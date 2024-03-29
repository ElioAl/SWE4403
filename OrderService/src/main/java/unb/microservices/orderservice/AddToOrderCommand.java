package unb.microservices.orderservice;

public class AddToOrderCommand extends Command{
    private String item;
    @Override
    public void execute() {
        Command.getOrder().getItems().add(item);
    }

    @Override
    public void undo() {
        Command.getOrder().getItems().remove(item);
    }

    public void setItem(String itm){
        item = itm;
    }
}
