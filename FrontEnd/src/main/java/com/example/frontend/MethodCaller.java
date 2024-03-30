package com.example.frontend;

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
}
