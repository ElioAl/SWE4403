package unb.microservices.orderservice;

public abstract class Command {
    public Order currentOrder;

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public abstract void execute();
    public abstract void undo();
}
