package com.example.frontend;

import java.util.Scanner;

public class Login {
    public static void login(){
        String username = "";
        String password = "";
        System.out.println("-----Welcome to ...-----");
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = false;
        while(!loggedIn) {
            System.out.println("Login or Signup");
            String in = scan.nextLine();
            if (in.equals("Signup")) {
                System.out.print("Enter a new username: ");
                username = scan.nextLine();
                System.out.print("Enter desired password: ");
                password = scan.nextLine();
                System.out.println(username + " " + password);
                //call Customer Service Method to add user
                loggedIn = true;
            } else if (in.equals("Login")) {
                System.out.print("username: ");
                username = scan.nextLine();
                System.out.print("password: ");
                password = scan.nextLine();
                System.out.println(username + " " + password);
                loggedIn = true;
            } else {
                System.out.println("Incorrect Command");
            }
        }
    }
}