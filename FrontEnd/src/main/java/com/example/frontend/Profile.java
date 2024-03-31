package com.example.frontend;

import com.example.frontend.SharedDataTypes.Product;
import com.example.frontend.SharedDataTypes.User;

public class Profile {
    public void getProfile(User user){
        System.out.println("username: " + user.getUsername());
    }
}
