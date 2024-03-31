package com.example.databasemanagementsystem;

import SharedDataTypes.Order;
import SharedDataTypes.Product;
import SharedDataTypes.ProductPacket;
import SharedDataTypes.User;
import org.springframework.web.bind.annotation.*;
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
    public void add_product(@RequestParam("name") String name,
                            @RequestParam("cost") double cost,
                            @RequestParam("quantity") int quantity,
                            @RequestParam("type") String type) throws UnauthorizedAccessException {

        System.out.println("Yabadabadoo " + name + " " + cost + " " + quantity + " " + type);
        //db.add_product(name, cost, quantity, type);
    }


    @GetMapping("/get_product")
    public ProductPacket get_product(@RequestParam("product_ID") int product_ID){
        //Product p = db.get_product(product_ID);
        System.out.println("ID: " + product_ID);
        Product p = new Product(product_ID, "Eggs", 1000000, 69, "dairy");
        return serialize(p);
    }

    @PostMapping("/update_product")
    public void update_product(@RequestBody ProductPacket toUpdate) throws UnauthorizedAccessException {
        Product result = deSerialize(toUpdate);
        //db.update_product(result);
        System.out.println(result.getName());
    }

    @GetMapping("delete_product")
    public ProductPacket delete_product(@RequestParam("product_ID") int product_ID) throws UnauthorizedAccessException {
        //Product toReturn = db.delete_product(product_ID);
        Product toReturn = new Product(product_ID, "Cheese", 1000000, 69, "dairy");
        return serialize(toReturn);
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
    public void placeOrder(@RequestParam("order_ID") int order_ID, @RequestBody ListWrapper order){
        db.placeOrder(order_ID, order.getObject());
    }

    @PostMapping("/cancelOrder")
    public void cancelOrder(@RequestParam("order_ID") int order_ID) throws UnauthorizedAccessException {
        db.cancelOrder(order_ID);
    }

    private ProductPacket serialize (Product toSerialize) {
        return new ProductPacket(toSerialize.getProduct_ID(), toSerialize.getName(), toSerialize.getCost(), toSerialize.getQuantity(), toSerialize.getCategory());
    }
    private Product deSerialize(ProductPacket toDeserialize) {
        return new Product(toDeserialize.product_ID, toDeserialize.name, toDeserialize.cost, toDeserialize.quantity, toDeserialize.type);
    }
}
