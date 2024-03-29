package com.example.databasemanagementsystem;

import SharedDataTypes.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DBMSController {

    private RestTemplate restTemplate;

    @PostMapping("/add_product")
    public void add_product(@RequestBody Product toAdd){
        System.out.println("RECEIVEDDDDDDDDDDDDDDDD");
        Database db = new DBAccess();
        //db.add_product(toAdd.getName(), toAdd.getCost(), toAdd.getQuantity(), toAdd.getCategory());
    }
}
