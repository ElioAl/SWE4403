package SharedDataTypes;

public class Product {
    private int product_ID;
    private String name;
    private double cost;
    private int quantity;

    public Product(int product_ID, String name, double cost, int quantity){
        this.product_ID = product_ID;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    public int getProduct_ID(){
        return product_ID;
    }

    public String getName(){
        return name;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }
}
