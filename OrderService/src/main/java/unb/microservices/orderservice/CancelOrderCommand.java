package unb.microservices.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CancelOrderCommand extends Command{
    @Autowired
    private RestTemplate restTemplate;

    private int orderId;

    @Override
    public void setItem(Product item) {

    }

    @Override
    public void execute() {
        Command.setCurrentOrder(new Order());
        String url = "http://localhost:8081/cancelOrder?orderId={orderId}";

        HttpEntity<Object> entity = new HttpEntity<>(new Object());
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("orderId", orderId);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class, uriVariables);
        //add database method
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public void undo() {
        Command placeOrderCommand = new PlaceOrderCommand();
        placeOrderCommand.execute();
    }
}
