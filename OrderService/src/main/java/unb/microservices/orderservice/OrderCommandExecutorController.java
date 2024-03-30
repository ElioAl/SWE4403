package unb.microservices.orderservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class OrderCommandExecutorController {
    private OrderCommandExecutor executor = new OrderCommandExecutor();
    private RestTemplate restTemplate;

    @PostMapping("/addToOrder")
    public void add(@RequestParam("userId") int userId, @RequestBody Product item){
        System.out.println("added to order");
        executor.addToOrder(item, userId);
    }

    @PostMapping("/removeFromOrder")
    public void remove(@RequestBody Product item){
        System.out.println("removed from order");
        executor.removeFromOrder(item);
    }

    @PostMapping("/placeOrder")
    public void place(@RequestParam("cardNumber") int cardNumber, @RequestParam("amountInCard") double amountInCard, @RequestBody Object object){
        System.out.println("placed order");
        executor.placeOrder(cardNumber, amountInCard);
    }
    @PostMapping("/cancelOrder")
    public void cancel(@RequestParam("orderId") int orderId, @RequestBody Object object){
        System.out.println("cancelled order");
        executor.cancelOrder(orderId);
    }

    @PostMapping("/undo")
    public void undo(@RequestBody Object object){
        System.out.println("undo");
        executor.undo();
    }

    @PostMapping("/showCart")
    public void showCart(@RequestBody Object object){
        System.out.println("Show cart");
        executor.showCart();
    }
}
