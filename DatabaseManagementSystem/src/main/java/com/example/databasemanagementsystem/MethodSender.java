package com.example.databasemanagementsystem;

import SharedDataTypes.Product;
import SharedDataTypes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class MethodSender {

    private RestTemplate restTemplate = new RestTemplate();

    public void sendAuthority(int authority){
        String url = "http://localhost:8086/getAuthority?in={in}";

        //HttpEntity<Object> entity = new HttpEntity<>(new Object());

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("in", authority);

        ResponseEntity<String> response = restTemplate.postForEntity(url, null, String.class, uriVariables);
    }

    public void sendCategory(ArrayList<Product> toSend){
        String url = "http://localhost:8086/sendCategory";

        ListWrapper wrapper = new ListWrapper(toSend);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ListWrapper> entity = new HttpEntity<>(wrapper);

        ResponseEntity<String> reponse = restTemplate.postForEntity(url, entity, String.class);
    }

    public void sendUser(User user){
        String url = "http://localhost:8083/receiveCustomer";
        HttpEntity<User> entity = new HttpEntity<>(user);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
    }
}
