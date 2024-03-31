package unb.cb.customerservice;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public String addCustomer(String username, String password) {
        customerService.addCustomer(username, password);
        return "Customer added successfully";
    }

    public String deleteCustomer(String username, String password) {
        customerService.deleteCustomer(username, password);
        return "Customer deleted successfully";
    }

    public String addToOrder(String item) {
        customerService.addToOrder(item);
        return "Item added to order successfully";
    }

    public String cancelOrder() {
        customerService.cancelOrder();
        return "Order cancelled successfully";
    }

    public String processPayment(float amount, int cardNumber, int amountInCard) {
        customerService.processPayment(amount, cardNumber, amountInCard);
        return "Payment processed successfully";
    }
}
