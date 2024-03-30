package com.example.databasemanagementsystem;

import SharedDataTypes.Order;
import SharedDataTypes.Product;
import SharedDataTypes.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class DBMSController {

    MethodSender send = new MethodSender();

    Database db = new DBAccess();
    private RestTemplate restTemplate;

    @PostMapping("/add_user")
    public void add_user (@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type) {
        //db.add_user(username, password, type);
        System.out.println("sup fuckers " + username + " " + password + " " + type);
    }

    @PostMapping("/delete_user")
    public void delete_user(@RequestParam("username") String username, @RequestParam("password") String password) throws UnauthorizedAccessException {
        db.delete_user(username, password);
    }

    @PostMapping("/getUserForAuthority")
    public void getUserForAuthority(@RequestParam("username") String username, @RequestParam("password") String password){
        db.getUserForAuthority(username, password);
        send.sendAuthority(db.sendAuthority());
    }

    @PostMapping("/sendAuthority")
    public void sendAuthority(){
        db.sendAuthority();
    }

    @PostMapping("/add_product")
    public void add_product(@RequestBody Product toAdd) throws UnauthorizedAccessException {
        db.add_product(toAdd.getName(), toAdd.getCost(), toAdd.getQuantity(), toAdd.getCategory());
    }

    @PostMapping("/get_product")
    public void get_product(@RequestParam("product_ID") int product_ID){
        db.get_product(product_ID);
    }

    @PostMapping("/update_product")
    public void update_product(@RequestBody Product toUpdate) throws UnauthorizedAccessException {
        db.update_product(toUpdate);
    }

    @PostMapping("delete_product")
    public void delete_product(@RequestParam("product_ID") int product_ID) throws UnauthorizedAccessException {
        Product toReturn = db.delete_product(product_ID);
    }

    @PostMapping("/getCategory")
    public void getCategory(@RequestParam("category") String category){
        ArrayList<Product> toReturn = new ArrayList<>();
        toReturn = db.getCategory(category);
    }

    @PostMapping("/setProductQuantity")
    public void setProductQuantity(@RequestParam("product_ID") int product_ID, @RequestParam("quantity") int qunatity) throws UnauthorizedAccessException {
        db.setProductQuantity(product_ID, qunatity);
    }

    @PostMapping("/placeOrder")
    public void placeOrder(@RequestParam("order_ID") int order_ID, @RequestBody ArrayList<Product> order){
        db.placeOrder(order_ID, order);
    }

    @PostMapping("/cancelOrder")
    public void cancelOrder(@RequestParam("order_ID") int order_ID) throws UnauthorizedAccessException {
        db.cancelOrder(order_ID);
    }
}
