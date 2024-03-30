package com.example.paymentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Properties;

@RestController
public class PaymentController {

    private RestTemplate restTemplate;

    @PostMapping("/pay")
    public void pay(@RequestParam("userId") int userId, @RequestBody ListWrapper items, @RequestParam("cardNumber") int cardNumber, @RequestParam("amount") int amountInCard){
        System.out.println("RECEIVEDDDDDDDDDDDDDDDD");
        Payment tempPay = new Payment(userId, items.getObject(), cardNumber, amountInCard);
        tempPay.proccess();
    }
}
