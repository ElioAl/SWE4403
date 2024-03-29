package unb.microservices.PCS;

public class MeatProduct implements Product {
    private String itemName;
    private double pricePerKG;
    private double price;
    private double weightKG;


    @Override
    public void createProduct(Product purchasedProduct) {
        // send new object to db. all good EA
    }

    @Override
    public Product readProduct(int ID) {
        // request product from ID on the DB, returns a. All good EA
        return null;
    }
    @Override
    public void updateProduct(int ID) {
        // need to update the signature of this method.
        //from Elio: If u can, send me a Product object, check out the Product class in SharedDataTypes package in DBMS
        // update a product in the db.
    }

    @Override
    public Product deleteProduct(int ID) {
        //delete the product and return it. all good EA
        return null;
    }

    @Override
    public void setItemName(String name) {
        itemName = name;
    }

    @Override
    public void setPrice(double p) {
        price = p;
    }
}
