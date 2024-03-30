package com.example.frontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

public class View {

    public static void CustomerView(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Home\n - Enter\nCart - to view your cart" +
                    "\nOrder - to view an order status" +
                    "\nCategories - to view all categories" +
                    "\nProfile - to view your profile" +
                    "\nExit - To Exit the application");
            String in = scan.nextLine().toLowerCase();
            switch(in){
                case "cart":
                    //return cart
                    break;

                case "order":
                    System.out.print("Enter your order ID: ");
                    int order_ID = scan.nextInt();
                    System.out.println();
                    System.out.println(order_ID);
                    //return order
                    break;

                case "categories":
                    System.out.println("-------------------------");
                    System.out.println("|\tDairy\t|\tMeat\t|");
                    System.out.println("-------------------------");
                    System.out.println("Select a Category to View The Products or Enter Return to Return to Menu");
                    String cat = "";
                    while(!(cat.equals("menu"))){
                        cat = scan.nextLine().toLowerCase();
                        if(cat.equals("dairy") || cat.equals("meat")){
                            Categories.getList(cat);
                        } else {
                            System.out.println("Invalid category");
                        }
                    }
                    break;
                case "profile":
                    //return profile
                    //System.out.println("");
                    break;
                case "exit":
                    System.exit(1);
            }
        }
    }

    public static void RetailerView(){
        System.out.println("Home\n - Enter\nOrder - to view an order status" +
                "\nCategories - to view all categories" +
                "\nProfile - to view your profile" +
                "\nExit - To Exit the application");
    }
}
