package com.example.frontend;

import com.example.frontend.SharedDataTypes.User;

import java.util.Scanner;

public class Login {
    public static User login(){
        String username = "";
        String password = "";
        int authority = 1;
        System.out.println("-----Welcome to ...-----");
        Scanner scan = new Scanner(System.in);
        boolean loggedIn = false;
        User userIn = null;
        while(!loggedIn) {
            System.out.println("Login or Signup");
            String in = scan.nextLine();
            if (in.equals("Signup")) {
                System.out.print("Enter a new username: ");
                username = scan.nextLine();
                System.out.print("Enter desired password: ");
                password = scan.nextLine();
                System.out.println(username + " " + password);
                //call Customer Service Method to add user + return user
                loggedIn = true;
            } else if (in.equals("Login")) {
                System.out.print("username: ");
                username = scan.nextLine();
                System.out.print("password: ");
                password = scan.nextLine();
                System.out.println(username + " " + password);
                //check if user is valid + return User
                loggedIn = true;
            } else {
                System.out.println("Incorrect Command");
            }
        }
        //send the user to DBMS
        //get authority from DBMS
        if(authority == 1){
            View.CustomerView();
        } else {
            View.RetailerView();
        }
        return userIn;
    }
}