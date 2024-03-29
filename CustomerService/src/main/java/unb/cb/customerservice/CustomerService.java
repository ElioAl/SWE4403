package unb.cb.customerservice;

import org.springframework.stereotype.Service;

@Service
public class CustomerService implements Customer {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addCustomer(String username, String password) {

    }

    @Override
    public void deleteCustomer(String username, String password) {
        user_DB.delete_user(username, password);
    }

    @Override
    public void addToOrder(String item) {
        AddToOrderCommand addToOrderCommand = new AddToOrderCommand();
        addToOrderCommand.setItem(item);
        addToOrderCommand.execute();
    }

    @Override
    public void cancelOrder() {
        CancelOrderCommand cancelOrderCommand = new CancelOrderCommand();
        cancelOrderCommand.execute();
    }

    @Override
    public void processPayment(float amount, int cardNumber, int amountInCard) {
        Payment payment = new Payment(amount, cardNumber, amountInCard);
        payment.proccess();
    }


}
