package unb.microservices.PCS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PCSApplication {


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

}
