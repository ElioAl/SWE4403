package com.example.databasemanagementsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
