package unb.microservices.orderservice;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderCommandExecutor {
    private ArrayList<String> log;
    private ArrayList<Command> queue;

    private RestTemplate restTemplate = new RestTemplate();

    private Order order;

    public void createOrder(int id){
        order = new Order(id, new ArrayList<Product>());
        Command.setCurrentOrder(order);
    }

    public void addToOrder(Product item, int id){
        if(order == null){
            createOrder(id);
        }

        Command addToOrder = new AddToOrderCommand();
        addToOrder.setItem(item);
        addToOrder.execute();
        log.add("Added " + item.getName());
        queue.add(addToOrder);
    }

    public void removeFromOrder(Product item){
        Command removeFromOrder = new RemoveFromOrderCommand();
        removeFromOrder.setItem(item);
        removeFromOrder.execute();
        log.add("Removed " + item.getName());
        queue.add(removeFromOrder);
    }

    public void placeOrder(int cardNumber, double amountInCard){
        PlaceOrderCommand placeOrder = new PlaceOrderCommand();
        placeOrder.setAmountInCard(amountInCard);
        placeOrder.setCardNumber(cardNumber);

        placeOrder.execute();
        log.add("Placed Order ");
        queue.add(placeOrder);
    }

    public void cancelOrder(int orderId){
        CancelOrderCommand cancelOrder = new CancelOrderCommand();
        cancelOrder.setOrderId(orderId);

        cancelOrder.execute();
        log.add("Cancelled Order ");
        queue.add(cancelOrder);
    }

    public void undo(){
        int len = queue.size();
        log.add("Undid last action");
        queue.get(len-1).undo();
        queue.remove(len-1);
    }

    public void showCart() {
        for (Product item : Command.getOrder().getItems()) {
            System.out.println(item.getName() + " : " + item.getCost());
        }
        String url = "http://localhost:8086/showCart";
        ListWrapper productListWrapper = new ListWrapper(Command.getOrder().getItems());
        // populate productListWrapper with your products
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ListWrapper> entity = new HttpEntity<>(productListWrapper, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

    }
}
