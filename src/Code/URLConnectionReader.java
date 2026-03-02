package Code;
import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL website = new URL("https://pokecardmaker.net/card/SaylorMay/wind-sprite-1ht0z5u");
        BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));

        String inputLine;
        int x = 0;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(String.valueOf(x) + inputLine + "\n");
            x++;
        }
        in.close();
    }
}
