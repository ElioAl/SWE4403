package com.example.frontend;

import com.example.frontend.SharedDataTypes.CustomerService;
import com.example.frontend.SharedDataTypes.ListWrapper;
import com.example.frontend.SharedDataTypes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class MethodCaller {

    private RestTemplate restTemplate = new RestTemplate();

    public void addToOrder(Product product){
        String url = "http://localhost:8082/addToOrder?userId={userId}";
        HttpEntity<Product> entity = new HttpEntity<>(product);

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("userId", FrontEndApplication.loggedIn.getUser_ID());

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class, uriVariables);
    }

    public void getUser(){
        String url = "http://localhost:8083/getUser";
        CustomerService customer = restTemplate.getForObject(url, CustomerService.class);
    }

    public void removeFromOrder(Product product){
        String url = "http://localhost:8082/removeFromOrder";
        HttpEntity<Product> entity = new HttpEntity<>(product);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
    }

    //Revise this method to send without entity
    public void placeOrder(int cardNumber, double amountInCard){
        String url = "http://localhost:8082/placeOrder?cardNumber={cardNumber}&amountInCard={amountInCard}";


        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("cardNumber", cardNumber);
        uriVariables.put("amountInCard", amountInCard);

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class, uriVariables);
    }

    public void cancelOrder(int orderId){
        String url = "http://localhost:8082/cancelOrder?orderId={orderId}";

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("orderId", orderId);

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class, uriVariables);
    }

    public void undoActionForCart(){
        String url = "http://localhost:8082/undo";

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
    }

    public void showCart(){
        String url = "http://localhost:8082/showCart";
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class);
        }
        catch(HttpServerErrorException e){
            System.out.println("No orders Placed Yet");
        }
    }

    public void sendUserforAuthority(String username, String password){
        String url = "http://localhost:8081/getUserForAuthority?username={username}&password={password}";

        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("password", password);

        //HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);
        try{
            ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class, requestBody);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addUser(String username, String password){
        String url = "http://localhost:8083/addCustomer?username={username}&password={password}";

        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class, params);
    }

    public void getList(String category){
        String url = "http://localhost:8081/getCategory?category={category}";

        Map<String, Object> params = new HashMap<>();
        params.put("category", category);

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class, params);
    }
}
