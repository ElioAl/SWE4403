package com.example.frontend;

import com.example.frontend.SharedDataTypes.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Cart {

    ArrayList<Product> cart;
    MethodCaller caller = new MethodCaller();
    public void displayCart(ArrayList<Product> list){
        this.cart = list;
        int counter = 1;
        System.out.println("--------------------------------\n");
        System.out.printf("|\t%-20s %s: %-20s\n", "Index", "Item Name", "Item Cost");
        System.out.println("--------------------------------\n");
        for (Product item: list) {
            System.out.printf("|\t%-20s %s: %-20s\n", counter, item.getName(), item.getCost());
            counter++;
        }

        Cart cart = new Cart();
        System.out.println("In cart");
        System.out.println("To Remove a Product from the List, Enter \"Delete\"");
        System.out.println("To Change the Quantity of a Product, Enter \"Change Quantity\"");
        System.out.println("To Proceed to Checkout, Enter \"Checkout\"");
        System.out.println("To return to Menu, Enter \"Menu\"");
        Scanner scan = new Scanner(System.in);
        String input = "";
        while(!input.equals("menu")){
            input = (scan.nextLine()).toLowerCase();

            switch (input) {
                case "delete" -> deleteProduct();
                case "checkout" -> cart.placeOrder();
                default -> System.out.println("Invalid Command");
            }
        }
    }

    public void deleteProduct(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Index of the product you would like to remove from the Cart");
        System.out.print("Index: ");
        int input = scan.nextInt();
        //remove product
        caller.removeFromOrder(this.cart.get(input-1));
    }

    public void placeOrder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Card Number you would like to use to pay for the order and the amount on the card");
        System.out.println("Card Number: ");
        int cardNumber = scan.nextInt();
        System.out.println("Amount on card");
        double amount = scan.nextDouble();
        caller.placeOrder(cardNumber, amount);
        //Get confirmation
    }
    
    
}
