package com.example.frontend;

import java.util.Scanner;

public class OrderView {
    View view = new View();
    MethodCaller caller = new MethodCaller();
    Scanner scan = new Scanner(System.in);
    public void getOrderStatus(String status){
        System.out.println("----------------");
        System.out.println("Order number: " + View.order_ID);
        System.out.println("Order Status: " + status);
        while(true){
            System.out.println("To cancel an order, Enter \"cancel\" or to return to Menu, enter \"Menu\"");
            String input = scan.nextLine();
            if(input.equals("cancel")){
                caller.cancelOrder(View.order_ID);
                view.CustomerView();
            } else if(input.equals("menu")){
                view.CustomerView();
            } else {
                System.out.println("Invalid Command");
            }
        }
    }
}
