package Code;
import java.net.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {

        BufferedReader test = new BufferedReader(new FileReader("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\Code\\test.txt"));

        String accountSource = test.readLine();
        String evernightHTML = getUrlHtml("https://pokecardmaker.net/card/SaylorMay/evernight-mdi00sy");
        String rKnightHTML = getUrlHtml("https://pokecardmaker.net/card/SaylorMay/the-roaring-knight-duf05q0");
        String yuriHTML = getUrlHtml("https://pokecardmaker.net/card/SaylorMay/iono-canari-lbk0zb5");

        urlToCardList(accountSource);
    }

    public static Card htmlToClass(String htmlString) {

        Card card = new Card();

        card.setName(pullMakerStat(htmlString, ":false,\"name\":"));
        card.setHp(Integer.valueOf(pullMakerStat(htmlString, "hitpoints")));
        //card.setGitImgURL();
        card.setMakerImgURL("dhcjt92fxib5i.cloudfront.net/" + pullMakerStat(htmlString, "s3Key"));
        //card.setSuperType();
        //card.setCardNum();
        card.setSetID(pullMakerStat(htmlString, "totalInSet"));
        card.setCardNum(pullMakerStat(htmlString, "cardNumber"));
        //card.setSubtypes();

        return card;
    }

    public static String getUrlHtml(String url) throws Exception {
        URL website = new URL(url);
        BufferedReader site = new BufferedReader(new InputStreamReader(website.openStream()));
        String html = site.readLine();
        site.close();
        return html;
    }


    //
    public static Card[] urlToCardList(String source) throws Exception {
        List<String> URLList = new ArrayList<String>();
        String temp = "";
        while (source.contains("slug")) {
            temp = pullMakerStat(source, "slug");
            printMakerCardStats(getUrlHtml("https://pokecardmaker.net/card/SaylorMay/" + temp));
            System.out.println("");
            source = source.replaceFirst("slug", "");
        }
        return null;
    }


    public static void printMakerCardStats(String htmlString) {
        String name = pullMakerStat(htmlString, ":false,\"name\":");
        System.out.println(name + " HP: " + pullMakerStat(htmlString, "hitpoints"));
        System.out.println(name + " ImageURL: https://pokecardmaker.net/card/SaylorMay/" + pullMakerStat(htmlString, "s3Key"));
        System.out.println(name + " CardNumber: " + pullMakerStat(htmlString, "cardNumber"));
        System.out.println(name + " SetID: " + pullMakerStat(htmlString, "totalInSet"));
    }

    // key should be any string of characters before the "
    // For example:  "cardNumber":"37a"  should have the key as cardNumber and no "
    public static String pullMakerStat(String htmlString, String key) {
        boolean isValueFound = false;
        String returnedString = "";

        for (char currChar : htmlString.substring(htmlString.indexOf(key) + key.length()).toCharArray()) {
            if (currChar != '"' && currChar != ':') {
                returnedString = returnedString + currChar;
                isValueFound = true;
            } else if (isValueFound) {
                return returnedString;
            }
        }
        return returnedString;
    }
}
