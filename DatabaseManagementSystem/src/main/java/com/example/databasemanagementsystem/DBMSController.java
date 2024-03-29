package com.example.databasemanagementsystem;

import SharedDataTypes.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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


    @PostMapping("/add_user")
    public void add_user (@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type) {
        //do mafs

        System.out.println("in add user");
    }
}
