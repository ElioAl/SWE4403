package com.example.frontend;

import com.example.frontend.View;

import java.util.Scanner;

public class Cart {

    MethodCaller caller = new MethodCaller();
    public static void showCart(){
        Cart cart = new Cart();
        int result = 0;
        System.out.println("In cart");
        System.out.println("To Remove a Product from the Cart, Enter \"Delete\"");
        System.out.println("To Change the Quantity of a Product, Enter \"Change Quantity\"");
        System.out.println("To Proceed to Checkout, Enter \"Checkout\"");
        System.out.println("To return to Menu, Enter \"Menu\"");
        Scanner scan = new Scanner(System.in);
        String input = "";
        while(!input.equals("menu")){
            input = (scan.nextLine()).toLowerCase();

            switch (input) {
                case "delete" -> deleteProduct();
                case "change quantity" -> changeQuantity();
                case "checkout" -> cart.placeOrder();
                default -> System.out.println("Invalid Command");
            }
        }
    }

    private static void changeQuantity() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the product ID and the quantity you would like to remove");
        System.out.print("Product ID: ");
        int product_ID = scan.nextInt();
        System.out.println("\nQuantity: ");
        int quantity = scan.nextInt();

        //send to remove quantity
    }

    public static void deleteProduct(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Product ID you would like to remove from the Cart");
        System.out.print("Product ID: ");
        int input = scan.nextInt();
        //remove product
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
