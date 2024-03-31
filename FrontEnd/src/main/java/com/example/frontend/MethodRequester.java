package com.example.frontend;

import com.example.frontend.SharedDataTypes.ListWrapper;
import com.example.frontend.SharedDataTypes.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodRequester {
    @PostMapping("/getAuthority")
    public void getAuthority(@RequestParam("in") int in){
        Login.setAuthority(in);
    }
    @PostMapping("/showCart")
    public void showCart(@RequestBody ListWrapper cart){
        for (Product item: cart.getObject()) {
            System.out.println(item.getName() + " : " + item.getCost());
        }
    }
}
