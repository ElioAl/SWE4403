package com.example.frontend;

import java.util.Scanner;

public class View {

    MethodCaller caller = new MethodCaller();
    static int order_ID;
    public void CustomerView(){

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Home\nEnter One of the Following Options" +
                    "\n---------------------------------------------" +
                    "\nCart       -     to view your cart" +
                    "\nOrder      -     to view an order status" +
                    "\nCategories -     to view all categories" +
                    "\nProfile    -     to view your Profile" +
                    "\nLogout     -     to Logout of the application" +
                    "\nExit       -     to Exit the application" +
                    "\n---------------------------------------------");
            String in = scan.nextLine().toLowerCase();
            switch(in){
                case "cart":
                    caller.showCart();
                    break;

                case "order":
                    //get all orders for a user first
                    System.out.print("Enter your order ID: ");
                    order_ID = scan.nextInt();
                    scan.nextLine();
                    System.out.println("order ID: (I'm in view line 34) " + order_ID);
                    caller.getOrderStatus(order_ID);
                    break;

                case "categories":
                    String cat = "";
                    while(!(cat.equals("menu"))){
                        System.out.println("-------------------------");
                        System.out.println("|\tDairy\t|\tMeat\t|");
                        System.out.println("-------------------------");
                        System.out.println("Select a Category to View The Products or Enter Return to Return to Menu");
                        cat = scan.nextLine().toLowerCase();
                        if(cat.equals("dairy") || cat.equals("meat")){
                            caller.getList(cat);
                        } else {
                            System.out.println("Invalid category");
                        }
                    }
                    break;

                case "profile":
                    Profile profile = new Profile();
                    profile.getProfile(FrontEndApplication.loggedIn);
                    break;

                case "exit":
                    System.exit(1);
                    break;

                case "logout":
                    //Logout, change userLoggedIn = null in DB
                    Login login = new Login();
                    login.login();

                default:
                    System.out.println("Unknown Command");
            }
        }
    }

    public void RetailerView(){
        System.out.println("Home\n - Enter\nOrder - to view an order status" +
                "\nCategories - to view all categories" +
                "\nProfile - to view your profile" +
                "\nExit - To Exit the application");
    }
}
