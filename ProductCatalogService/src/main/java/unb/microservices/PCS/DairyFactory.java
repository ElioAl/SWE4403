package unb.microservices.PCS;

public class DairyFactory implements ProductFactory{
    @Override
    public Product createTransport() {
        return new DairyProduct();
    }
}
