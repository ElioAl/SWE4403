package com.example.frontend;

import com.example.frontend.SharedDataTypes.Product;
import com.example.frontend.SharedDataTypes.User;

public class Profile {
    public void getProfile(User user){
        FrontEndApplication.loggedIn = user;
        System.out.println("username: " + user.getUsername());
    }
}
