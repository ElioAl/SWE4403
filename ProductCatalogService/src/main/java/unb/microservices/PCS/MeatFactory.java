package unb.microservices.PCS;

public class MeatFactory implements ProductFactory{
    @Override
    public BaseProduct createTransport() {
        return new MeatProduct();
    }
}
