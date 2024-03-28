package SharedDataTypes;

public class Order {
    private int order_ID;
    private int product_ID;
    private int user_ID;

    public Order(int order_ID, int product_ID, int user_ID){
        this.order_ID = order_ID;
        this.product_ID = product_ID;
        this.user_ID = user_ID;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public int getUser_ID() {
        return user_ID;
    }
}
