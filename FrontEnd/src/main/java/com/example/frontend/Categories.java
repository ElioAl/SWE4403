package com.example.frontend;

import com.example.frontend.SharedDataTypes.Product;

import java.util.ArrayList;

public class Categories {
    public void getList(ArrayList<Product> list) {
        System.out.println("In getList");
        for(Product x: list){
            System.out.println(x.getProduct_ID() + " " + x.getName() + " " + x.getCost() + " " + x.getQuantity());
        }
        //request list of products in category from db
    }
}
