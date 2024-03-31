package com.example.frontend;

import com.example.frontend.SharedDataTypes.User;

import java.util.Scanner;

public class Login {
    static int authority = 0;

    static String username = "";
    static String password = "";
    public static User login(){
        MethodCaller name = new MethodCaller();

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
                name.addUser(username, password);
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


        name.sendUserforAuthority(username, password);

        View view = new View();

        if(authority == 1){
            view.CustomerView();
        } else {
            view.RetailerView();
        }
        return userIn;
    }

    public static void setAuthority(int in){
        authority = in;
    }
}