package code;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import tools.jackson.databind.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class DebugMethods {


    // SaylorMay is 1781855048820L

    public static void main(String[] args) throws Exception {

        //finalMethod("https://api.pokecardmaker.net/cards/users/cmhlgx2v5000jju040pgpe7ty?limit=8&sortBy=new", "Tyratruns", "Tyratruns.json);
        finalMethod("https://api.pokecardmaker.net/cards/users/cmh4al993005rl404xsbaup4r?limit=8&sortBy=new", "SaylorMay", "SaylorMay2.json", 1781855048820L, "1.1");
    }

    //DONE!!!  1) Get the list of json files containing all the references to cards
    //DONE!!   2) Convert to a massive list of individual card URLs
    //For each card you must:
    // 3) Upload Catbox image
    // 4) Grab all the info and turn it into a Card object
    // 5) Put all Card objects into a Card ArrayList
    //Returning to one file
    // 6) Make the big json object, and then iterate through each Card, adding it to the json
    //FINISHED!!!
    public static void finalMethod(String accountURL, String userName, String exportName, long timestamp, String version) throws Exception {

        // #1 + #2
        ArrayList<String> slugs = getAllCardLinks(accountURL);

        ArrayList<Card> cards = new ArrayList<>();
        for (String slug : slugs) {
            System.out.println("Grabbing info from " + slug);
            cards.add(makerLinkToCard("https://api.pokecardmaker.net/cards/by-slug?username=" + userName + "&slug=" + slug));
            Thread.sleep((long) (Math.random() * 1000));
        }

        List<EnvoyCard> envoyCards = new ArrayList<>();

        // A place to calculate the name ahead of time, since you only want to put the prefix in front of a Pokemon, not a Trainer
        String concatenatedName = "";

        // Incremented on each iteration to track importOrder
        int importOrder = 0;

        for (Card card : cards) {
            // Will combine the prefix and main name if it's a name, but not if otherwise
            if (card.getSuperType().equals("Pokémon")) { concatenatedName = card.getPrefix() + " " + card.getName();}
            else {concatenatedName = card.getName();}

            envoyCards.add(
                    new EnvoyCard(
                            concatenatedName,
                            card.getIdNum(),
                            card.getSetId(),
                            card.getImageLink(),
                            "custom-" + version + "-mexp" + card.getSetId() + card.getIdNum(),
                            card.getHp(),
                            card.getSuperType(),
                            card.getCreationDate(),
                            importOrder
                    ));

            importOrder++;
        }

        EnvoySet envoySet = new EnvoySet(envoyCards, timestamp, version);

        System.out.println(envoySetToJson(envoySet, "src/exports/testJsons/" + exportName));

    }


//    public static void test1() throws Exception {
//        System.out.println(new Card());
//        System.out.println(Conversion.sourceToCard(Conversion.getURLSource("https://pokecardmaker.net/card/SaylorMay/seele-8t13q2cdy")));
//    }
//
//    public static void test2() throws Exception {
//        Document doc = Jsoup.connect("https://pokecardmaker.net/card/SaylorMay/hatsune-miku-0igp29v9").get();
//        // h1: "Hatsune Miku"
//
//
//        ArrayList<Element> preparsedList = doc.select("span").asList();
//        ArrayList<Element> parsedList = new ArrayList<>();
//
//
//        for (Element element : preparsedList) {
//            /* Requirements
//            * 1) Not empty
//            * 2) Not just "•"
//            *  */
//            String text = element.text();
//            if (!element.text().equals("") &&
//            !text.isEmpty() &&
//            !text.equals("Create") &&
//            !text.equals("PokeCardMaker.net") &&
//            !text.equals("Browse") &&
//            !text.equals("Sign in") &&
//            !text.equals("More") &&
//            !text.equals("•") &&
//            !text.equals("Add to cart") &&
//            !text.equals("Download image") &&
//            !text.equals("Includes assets by Creatures Inc.")) {
//                System.out.println(element.text());
//            }
//        }
//    }
//
//    public static void test3() throws Exception {
//        String url = "https://api.pokecardmaker.net/cards/users/cmh4al993005rl404xsbaup4r?limit=8&sortBy=new";
//        int pageLimit = 30;
//
//        String json = "";
//
//        // Stores the next cursor listed at the end of the current json page
//        int nextPage = 0;
//
//
//        for (int i = 0; i < pageLimit && nextPage != -1; i++) {
//            json = Jsoup.connect(url + "&cursor=" + nextPage)
//                    .ignoreContentType(true)
//                    .execute()
//                    .body();
//            nextPage = onlyDigits(json.substring(json.length() - 8));
//            System.out.println("Page #: " + i);
//            System.out.println(json);
//        }
//    }
//
//    public static void test4() throws Exception {
//
//        String url = "https://api.pokecardmaker.net/cards/users/cmh4al993005rl404xsbaup4r?limit=8&sortBy=new";
//        int pageLimit = 50;
//
//        String json = "";
//        boolean finishedFlag = false;
//
//        for (int i = 0; i < pageLimit && !finishedFlag; i++) {
//            json = Jsoup.connect(url + "&cursor=" + i)
//                    .ignoreContentType(true)
//                    .execute()
//                    .body();
//            if (isPokeEmpty(json)) {
//                finishedFlag = true;
//            } else {
//                exportJson(json, "C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\tempJSONs", i + ".json");
//                System.out.println("#i:/n" + json);
//            }
//        }
//    }

    public static void test5() {
        JsonNode everBados = new ObjectMapper().readTree(new File("src/exports/testJsons/everbados.json"));
        System.out.println(everBados.get("version"));
    }

    public static void test6() throws Exception {
        EnvoySet envoySet = new EnvoySet();
        envoySet.version = "1.0";
        envoySet.data.add(new EnvoyCard());
        envoySet.data.add(new EnvoyCard());
        System.out.println(envoySetToJson(envoySet, "src/exports/testJsons/blank4.json"));
    }

    public static void test7() throws Exception {

        Card exampleCard = makerLinkToCard("https://api.pokecardmaker.net/cards/by-slug?username=SaylorMay&slug=kasane-teto-d0ya38d3");
        List<EnvoyCard> envoyCards = new ArrayList<>();
        envoyCards.add(new EnvoyCard(exampleCard.getPrefix() + exampleCard.getName(), exampleCard.getIdNum(), exampleCard.getSetId(), exampleCard.getCatBoxImgLink()));
        EnvoySet envoySet = new EnvoySet(envoyCards);
        System.out.println(envoySetToJson(envoySet, "src/exports/testJsons/test3.json"));
    }

    public static boolean envoySetToJson(EnvoySet envoySet, String filePath) throws Exception {
        try {
            ObjectMapper mapper = new ObjectMapper();

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(filePath), envoySet);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    // Returns a Card class from a link to a PokeCardMaker card
    public static Card makerLinkToCard(String cardLink) throws Exception {

        // Gets the card's link and turns it into a readable JsonNode tree
        JsonNode attributes = new ObjectMapper()
                .readTree(Jsoup.connect(cardLink)
                        .ignoreContentType(true)
                        .execute()
                        .body());

        String superType = "";
        switch (attributes.get("supertypeId").toString()) {
            case "1":
                superType = "Pokémon";
                break;
            case "2":
                superType = "Trainer";
                break;
            case "3":
                superType = "Energy";
                break;
            default:
                superType = "Trainer";
                break;
        }

        // Rips the necessary information from the JsonNode to make a returnable Card representing the link
        return new Card(
                attributes.get("name").asText(),                    //Name
                attributes.get("subname").asText(),                 //Prefix
                attributes.get("cardNumber").asText(),              //ID Number
                attributes.get("totalInSet").asText(),              //Set ID
                "https://dhcjt92fxib5i.cloudfront.net/" + attributes.get("previewImage").get("s3Key").asText(), // Temp file solution to image
                cardLink,                                           //MakerLink
                attributes.get("hitpoints").asText(),   //Hp
                superType,                                           //SuperType
                attributes.get("createdAt").asText()
        );
    }


    // THE pageUrl STRING SHOULD BE AN API.POKECARDMAKER LINK
    public static ArrayList<String> getAllCardLinks(String pageURL) throws Exception {


        // Checks and saves the total number of cards to print an accurate progress bar!
        int totalCards = new ObjectMapper()
                .readTree(Jsoup.connect(pageURL)
                        .ignoreContentType(true)
                        .execute()
                        .body())
                .get("total").asInt();

        // Initial message announcing the collection of card links
        System.out.println("Retrieving " + totalCards + " from " + "[USER]" + "'s profile!");


        int pageLimit = 500;


        // The ArrayList that will hold every card link
        ArrayList<String> cardUrlList = new ArrayList<>();
        // The variable that temporarily holds the json from the current page
        String json = "";
        // A flag to tell the program to stop looping once it reached the last page
        boolean finishedFlag = false;

        for (int i = 0; i < pageLimit && !finishedFlag; i++) {
            try {
                json = Jsoup.connect(pageURL + "&cursor=" + i)
                        .ignoreContentType(true)
                        .execute()
                        .body();
                Thread.sleep((long) (Math.random() * 1000));

                if (isPokeEmpty(json)) {
                    finishedFlag = true;
                } else {
                    JsonNode items = new ObjectMapper()
                            .readTree(json)
                            .get("items");
                    for (JsonNode item : items) {
                        cardUrlList.add(item.get("slug").asText());
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Too many requests!  Waiting 10 seconds until trying again...");
                i--;
                Thread.sleep(10000);
            }

            // Will print out an update every other iteration
            if ((i % 1) == 0) {
                System.out.println("Progress: " + (int) (((double) cardUrlList.size() / totalCards) * 100) + "% (" + cardUrlList.size() + "/" + totalCards + ")");
            }
        }
        System.out.println("Success!!!  Retrieved " + cardUrlList.size() + " cards!!");
        return cardUrlList;
    }


    // Takes a string formatted to be a JSON and turns it to an actual JSON file on the computer
    // MAKE SURE THE NAME HAS .json AT THE END
    public static void exportJson(String json, String folderPath, String name) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        // Parse the JSON string to verify it's valid JSON
        JsonNode jsonNode = mapper.readTree(json);

        // Write pretty-printed JSON to the file
        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File(folderPath + "\\" + name), jsonNode);
    }

    // Checks if a number is a valid integer through a try-catch method
    public static boolean isInt(String intCandidate) {
        // Skips everything and returns false if it's "null" or null just for my own sanity
        if (intCandidate == null || intCandidate.equals("") || intCandidate.toLowerCase().equals("null")) {
            return false;
        }

        try {
            Integer.parseInt(intCandidate);
        }
        catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    // Removes any characters in a string that aren't digits and then returns it as an integer
    public static int onlyDigits(String input) {
        String temp = input.replaceAll("\\D", "");
        try {
            return Integer.parseInt(temp);
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }

    // Takes the json of a pokecardmaker USER!!!  And figures out if it's empty
    public static boolean isPokeEmpty(String json) {
        return json == null || json.isEmpty() || json.substring(0,12).equals("{\"items\":[],");
    }


    // Uploads an image url to catbox and returns the catbox url
    public static String uploadUrl(String url) {

        System.out.println("Uploading " + url);
        try {
            Connection.Response response = Jsoup.connect("https://catbox.moe/user/api.php")
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .userAgent("Mozilla/5.0")
                    .data("reqtype", "urlupload")
                    .data("url", url)
                    .execute();
            System.out.println(response.body());
            return response.body();
        }
        catch (Exception e) {
            return "INVALID URL";
        }
    }

    public static String backupUrlUpload(String url) throws Exception {

        System.out.println("Uploading " + url);

        File temp = File.createTempFile("upload", ".png");

        Files.copy(
                Jsoup.connect(url)
                        .ignoreContentType(true)
                        .userAgent("Mozilla/5.0")
                        .execute()
                        .bodyStream(),
                temp.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );

        String result = Jsoup.connect("https://catbox.moe/user/api.php")
                .ignoreContentType(true)
                .data("reqtype", "fileupload")
                .data("fileToUpload", temp.getName(), Files.newInputStream(temp.toPath()))
                .post()
                .body()
                .text();

        temp.delete();
        System.out.println(result);

        return result;
    }
}
