package com.example.frontend;

import com.example.frontend.SharedDataTypes.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class Categories {
    MethodCaller MC = new MethodCaller();
    public void getList(ArrayList<Product> list) {
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("|\t%-20s %-20s %-20s %-20s|\n", "Product ID", "Product Name", "Product Cost", "Product Quantity");
        System.out.println("----------------------------------------------------------------------------------------");

        for(Product temp : list){
            System.out.printf("|\t%-20d %-20s %-20.2f %-20d|\n", temp.getProduct_ID(), temp.getName(), temp.getCost(), temp.getQuantity());
        }
        System.out.println("----------------------------------------------------------------------------------------");


        String input = "";
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("To Add a Product to your Cart, Enter \"add product\" to add a Product, or Enter \"Menu\" to return to Menu");
            input = scan.nextLine().toLowerCase();
            if(input.equals("add product")){
                System.out.print("Enter product ID: ");
                int ID = scan.nextInt();
                scan.nextLine();
                for(Product temp : list){
                    if (temp.getProduct_ID() == ID) {
                        MC.addToOrder(temp);
                        System.out.println("Added to cart");
                        break;
                    }
                }

            } else if((input.equals("menu"))){
                View view = new View();
                view.CustomerView();
            } else {
                System.out.println("Incorrect Command");
            }

        }

    }
}
