package com.example.frontend;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodRequester {
    @PostMapping("/getAuthority")
    public void getAuthority(@RequestParam("in") int in){
        Login.setAuthority(in);
    }
}
