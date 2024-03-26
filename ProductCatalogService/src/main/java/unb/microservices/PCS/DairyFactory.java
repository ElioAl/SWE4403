package unb.microservices.PCS;

public class DairyFactory implements ProductFactory{
    @Override
    public BaseProduct createTransport() {
        return new DairyProduct();
    }
}
