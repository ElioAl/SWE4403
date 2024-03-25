package unb.microservices.orderservice;

public class Order {
    private String itemId;
    private int quantity;
    private String date;

    public Order(String id, int quan, String date){
        itemId = id;
        quantity = quan;
        this.date = date;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
