package unb.microservices.PCS;
public interface Product {
    static int idCounter = 1;
    public void createProduct(Product purchasedProduct);
    public Product readProduct(int ID);
    public void updateProduct(int ID);
    public Product deleteProduct(int ID);

}
