package com.example.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FrontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontEndApplication.class, args);
		Scanner scan = new Scanner(System.in);
		//Login.login();
 		while(true){
			System.out.println("Home - Enter\nCart - to view your cart" +
					"\nOrder - to view an order status" +
					"\nCategories - to view all categories" +
					"\nProfile - to view your profile" +
					"\nExit - To Exit the application");
			String in = scan.nextLine();
			switch(in){
				case "Cart":
					//return cart
					break;

				case "Order":
					System.out.print("Enter your order ID: ");
					int order_ID = scan.nextInt();
					System.out.println();
					System.out.println(order_ID);
					//return order
					break;

				case "Categories":
					System.out.println("-------------------------");
					System.out.println("|\tDairy\t|\tMeat\t|");
					System.out.println("-------------------------");
					break;
				case "Profile":
					//return profile
					//System.out.println("");
					break;
				case "Exit":
					System.exit(1);
			}
		}
	}

}
