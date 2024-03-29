package unb.microservices.PCS;

public class MeatFactory implements ProductFactory{
    @Override
    public Product createTransport() {
        return new MeatProduct();
    }
}
