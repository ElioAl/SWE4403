package unb.microservices.PCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//singleton class to manage db instance.
@Service
public class DBConnection {
    @Autowired
    private RestTemplate restTemplate;
    private static volatile DBConnection DBInstance;
    private DBConnection () {}

    public static DBConnection getDBInstance() {
        if (DBInstance == null)
            DBInstance = new DBConnection();
        return DBInstance;
    }


    public void createProduct(Product createdProduct) {
        String url = "http://localhost:8081/add_product";
        HttpEntity<Product> req = new HttpEntity<>(createdProduct);
        ResponseEntity<String> response = restTemplate.postForEntity(url, req, String.class);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Headers: " + response.getHeaders());
        System.out.println("Body: " + response.getBody());

    }

    public Product readProduct(int ID) {
        // request product from ID on the DB, returns a // ready in db named get_product. EA
        return null;
    }
    public void updateProduct(int ID) {
        // need to update the signature of this method.
        // update a product in the db.
        //ready in DB, names update_product, send a Product object. EA
    }

    public Product deleteProduct(int ID) {
        //delete the product and return it.
        //all good, name: delete_product, returns Product object. EA
        return null;
    }



    //specific update/read methods
}