package com.example.databasemanagementsystem;

import SharedDataTypes.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBMSController {

    @GetMapping("/add_product")
    public void add_product(@RequestBody Product toAdd){
        Database db = new DBAccess();
        db.add_product(toAdd.getName(), toAdd.getCost(), toAdd.getQuantity(), toAdd.getCategory());
    }
}
