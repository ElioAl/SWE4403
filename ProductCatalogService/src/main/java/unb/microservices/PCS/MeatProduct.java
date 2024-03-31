package unb.microservices.PCS;

public class MeatProduct implements Product {
    private String itemName;
    private double pricePerKG;
    private double price;
    private double weightKG;


    @Override
    public void setItemName(String name) {
        itemName = name;
    }

    @Override
    public void setPrice(double p) {
        price = p;
    }
}
