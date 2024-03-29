package unb.microservices.PCS;

import com.fasterxml.jackson.databind.ser.Serializers;

public class DairyProduct implements BaseProduct {
    private String itemName;
    private double price;
    private int id;

    @Override
    public void createProduct(BaseProduct purchasedProduct) {
        // send new object to db. //db method ready: named add_product. EA
    }

    @Override
    public BaseProduct readProduct(int ID) {
        // request product from ID on the DB, returns a // ready in db named get_product. EA
        return null;
    }
    @Override
    public void updateProduct(int ID) {
        // need to update the signature of this method.
        // update a product in the db.
        //ready in DB, names update_product, send a Product object. EA
    }

    @Override
    public BaseProduct deleteProduct(int ID) {
        //delete the product and return it.
        //all good, name: delete_product, returns Product object. EA
        return null;
    }

}
