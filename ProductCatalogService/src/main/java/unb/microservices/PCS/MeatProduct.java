package unb.microservices.PCS;

public class MeatProduct implements BaseProduct {
    private String itemName;
    private double pricePerKG;
    private double price;
    private double weightKG;


    @Override
    public void createProduct(BaseProduct purchasedProduct) {
        // send new object to db.
    }

    @Override
    public BaseProduct readProduct(int ID) {
        // request product from ID on the DB, returns a
        return null;
    }
    @Override
    public void updateProduct(int ID) {
        // need to update the signature of this method.
        // update a product in the db.
    }

    @Override
    public BaseProduct deleteProduct(int ID) {
        //delete the product and return it.
        return null;
    }
}
