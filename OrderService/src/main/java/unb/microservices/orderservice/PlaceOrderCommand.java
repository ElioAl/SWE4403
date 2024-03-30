package unb.microservices.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PlaceOrderCommand extends Command{

    @Autowired
    private RestTemplate restTemplate;
    private int cardNumber;
    private double amountInCard;

    @Override
    public void setItem(Product item) {

    }

    @Override
    public void execute() {
        String url = "http://localhost:8083/pay?userId={userId}&cardNumber={cardNumber}&amountInCard={amountInCard}";
        ListWrapper productListWrapper = new ListWrapper(Command.getOrder().getItems());
        // populate productListWrapper with your products
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ListWrapper> entity = new HttpEntity<>(productListWrapper, headers);

        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("userId", Command.getOrder().getUserId());
        uriVariables.put("cardNumber", cardNumber);
        uriVariables.put("amountInCard", amountInCard);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class, uriVariables);
    }

    public void setCardNumber(int cardNumber){
        this.cardNumber = cardNumber;
    }

    public void setAmountInCard(double amountInCard){
        this.amountInCard = amountInCard;
    }



    @Override
    public void undo() {
        Command cancelCommand = new CancelOrderCommand();
        cancelCommand.execute();
    }
}
