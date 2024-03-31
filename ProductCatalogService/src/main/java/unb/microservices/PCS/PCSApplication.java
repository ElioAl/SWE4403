package unb.microservices.PCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class PCSApplication implements CommandLineRunner {
	@Autowired
	private Product product;

	/**
	 * go to http://localhost:8080
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Booting up the PCS system...");
			SpringApplication.run(PCSApplication.class, args);
		}
		catch(Exception e) {
			System.out.println("Something went wrong: " + e.getMessage() + "/nStack Trace: ");
			e.printStackTrace();
		}
		System.out.println("PCS System online");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("here");
		product.setPrice(100);
		product.setItemName("A single egg");
	}

}
