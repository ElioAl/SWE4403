package unb.microservices.PCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



public class DairyProduct implements Product {
    private String itemName;
    private double price;
    DBConnection db = DBConnection.getDBInstance();




    public void setItemName(String name) {
        itemName = name;
    }
    public void setPrice(double p) {
        price = p;
    }






}
