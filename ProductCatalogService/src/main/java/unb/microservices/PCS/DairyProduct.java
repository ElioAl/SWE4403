package unb.microservices.PCS;

import com.fasterxml.jackson.databind.ser.Serializers;

public class DairyProduct implements BaseProduct {
    private String itemName;
    private double price;
    private int id;

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
