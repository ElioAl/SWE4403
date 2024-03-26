package unb.microservices.PCS;
public interface BaseProduct {
    static int idCounter = 1;
    public void createProduct(BaseProduct purchasedProduct);
    public BaseProduct readProduct(int ID);
    public void updateProduct(int ID);
    public BaseProduct deleteProduct(int ID);

}
