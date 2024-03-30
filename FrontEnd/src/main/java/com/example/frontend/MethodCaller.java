package com.example.frontend;

import com.example.frontend.SharedDataTypes.ListWrapper;
import com.example.frontend.SharedDataTypes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MethodCaller {

    @Autowired
    private RestTemplate restTemplate;

    public void addToOrder(Product product){
        String url = "http://localhost:8082/addToOrder?userId={userId}";
        HttpEntity<Product> entity = new HttpEntity<>(product);

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("userId", FrontEndApplication.loggedIn.getUser_ID());

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class, uriVariables);
    }

    public void removeFromOrder(Product product){
        String url = "http://localhost:8082/removeFromOrder";
        HttpEntity<Product> entity = new HttpEntity<>(product);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
    }

    //Revise this method to send without entity
    public void placeOrder(int cardNumber, int amountInCard){
        String url = "http://localhost:8082/placeOrder?cardNumber={cardNumber}&amountInCard={amountInCard}";

        HttpEntity<Object> entity = new HttpEntity<>(new Object());

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("cardNumber", cardNumber);
        uriVariables.put("amountInCard", amountInCard);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class, uriVariables);
    }

    public void cancelOrder(int orderId){
        String url = "http://localhost:8082/cancelOrder?orderId={orderId}";

        HttpEntity<Object> entity = new HttpEntity<>(new Object());

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("orderId", orderId);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class, uriVariables);
    }

    public void undoActionForCart(){
        String url = "http://localhost:8082/undo";

        HttpEntity<Object> entity = new HttpEntity<>(new Object());

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
    }

    public void showCart(){
        String url = "http://localhost:8082/showCart";

        HttpEntity<Object> entity = new HttpEntity<>(new Object());

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
    }

}
