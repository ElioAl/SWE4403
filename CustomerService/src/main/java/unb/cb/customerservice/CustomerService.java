package unb.cb.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerService implements Customer {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void addCustomer(String username, String password) {
        String url = "http://localhost:8081/add_user";
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("type", "customer");

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class, params);

    }

    @Override
    public void deleteCustomer(String username, String password) {

    }

    @Override
    public void addToOrder(String item) {

    }

    @Override
    public void cancelOrder() {

    }

    @Override
    public void processPayment(float amount, int cardNumber, int amountInCard) {

    }


}
