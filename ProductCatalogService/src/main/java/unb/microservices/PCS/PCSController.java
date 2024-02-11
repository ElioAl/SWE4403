package unb.microservices.PCS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PCSController {

    @GetMapping("/")
    public String Hello() {
        return "Hello World";
    }


    @GetMapping("/easteregg")
    public String EasterEgg() {
        String linebreaks = "<br>".repeat(100);
        return "Congratulations, you've found an easter egg!" + linebreaks +
                "4, 8, 15, 16, 23, 42";
    }
}
