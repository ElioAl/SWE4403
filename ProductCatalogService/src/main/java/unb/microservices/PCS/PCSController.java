package unb.microservices.PCS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class PCSController {

    @GetMapping("/")
    public String Hello() {
        return "Hello World";
    }


    @GetMapping("/easteregg")
    public String easterEgg() {
        String lb = "<br>";
        return "<div style='font-size:20px; font-weight:bold;'>" +
                "A secret whispered through the code," + lb +
                "An ancient path the Romans once trod." + lb +
                "By eight steps east, the shadows shift," + lb +
                "To unveil the hidden gift." + lb.repeat(2) +
                "VMDMZ OWVVI OQDM GWC CX" + lb.repeat(2) + "</div>" +
                "<form action='/submitAnswer' method='post'>" +
                "Answer: <input type='text' name='answer'/>" +
                "<input type='submit' value='Submit'/>" +
                "</form>";
    }

    /**
     * go to http://localhost:8080/easteregg
     * @param answer answer from the user
     * @return the result of the answer
     */
    @PostMapping("/submitAnswer")
    public String submitAnswer(@RequestParam("answer") String answer) {
        String backLink = "<a href='/easteregg'>Try again</a>";

        if (isAnswerCorrect(answer)) {
            String videoId = "dQw4w9WgXcQ";
            return "<div>Correct answer!</div>" + "<br>" +
                    "<button onclick='playVideo()'>Here is your reward!</button>" +
                    "<div id='videoContainer' style='display:none;'>" +
                    "<iframe id='videoFrame' width='560' height='315' src='https://www.youtube.com/embed/" + videoId + "?autoplay=1&mute=1' frameborder='0' allow='accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>" +
                    "</div>" +
                    "<script>" +
                    "function playVideo() {" +
                    "  var videoContainer = document.getElementById('videoContainer');" +
                    "  videoContainer.style.display = 'block';" + // Show the video container
                    "}" +
                    "</script>";
        } else {
            return "Sorry, that's not correct. " + backLink;
        }
    }

    private static String generateHash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes());
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public static boolean isAnswerCorrect(String userAnswer) {
        final String correctAnswerHash = "5618fc91f4bea53c1203f3cea4fb69e526cc5ae566550cd754707c297fc93779";
        try {
            String formattedAnswer = userAnswer.toLowerCase().replace(" ", "");
            String userAnswerHash = generateHash(formattedAnswer);
            return correctAnswerHash.equals(userAnswerHash);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }


    }
}
