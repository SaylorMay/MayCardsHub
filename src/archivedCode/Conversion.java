//package ArchivedCode;
//
//// Json uploader and reader
//import Code.Card;
//import tools.jackson.databind.ObjectMapper;
//
//// Reads files
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.InputStreamReader;
//import java.nio.file.Files;
//
//// URL stuff
//import java.net.URL;
//
//// Random Java utils
//import java.util.ArrayList;
//import java.util.List;
//
//// HTML conversion
//
//
//public class Conversion {
//
//
//// ----------------------------- DIRECT CONVERSION METHODS ------------------------------------ //
//
//
//
//    // Converts a given Pokecardmaker url and returns a String containing the html of the page
//    public static String getURLSource(String url) throws Exception {
//        Logger.log(Logger.LogType.SOURCE_EXTRACT,"Extracting Source from URL: " + url);
//        if (url == null) {return null;}
//        URL website = new URL(url);
//        try {
//            BufferedReader site = new BufferedReader(new InputStreamReader(website.openStream()));
//            String html = site.readLine();
//            site.close();
//            Logger.log(Logger.LogType.SOURCE_EXTRACT,"Source extracted from " + url + " successfully!");
//            return html;
//        }
//        catch (Exception e) {
//            Logger.log(Logger.LogType.ERROR,"Url Interpretation failed! Sending blank String...", "Conversion.getURLSource()");
//            return "";
//        }
//    }
//
//
//    // Converts a string from String containing the HTML of a pokecardmaker site
//    public static Card sourceToCard(String source) {
//
//        // If source is null, logs it and returns null
//        if (source == null) {
//            Logger.log(Logger.LogType.ERROR,"The given source was null! Returning null...", "Conversion.sourceToCard()");
//            return null;
//        }
//
////        Card tempCard = new Card(
////                pullMakerStat(source, ":false,\\\"name\\\":"),  // name
////                StringToInt(pullMakerStat(source, "hitpoints")),  // hp
////                "https://dhcjt92fxib5i.cloudfront.net/" + pullMakerStat(source, "s3Key"),  // imageURL
////                superTypeToString(StringToInt(pullMakerStat(source, "supertypeId"))),  // superType
////                pullMakerStat(source, "cardNumber"), // cardNum
////                pullMakerStat(source, "totalInSet"), // set
////                "", // ruleBox
////                null, // stage
////                typeIdToString(StringToInt(pullMakerStat(source, "\"typeId\""))),  // element
////                "PokecardMaker", // source
////                StringToInt(pullMakerStat(source, "subtypeId")) //  subType
////        );
////
////        Logger.log(Logger.LogType.SOURCE_INTERPRET,tempCard.getName() + " converted to Card object!", "Conversion.sourceToCard()");
//
//        return null;
//    }
//
//
//    // Converts a Card class to a .json file at the String path
//    public static String cardToJSON(Card card, String path) {
//
//        Logger.log(Logger.LogType.JSON_MAKER, "Making JSON file: " + path + "\\" + card.toFileName() + ".json");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(path + "\\" + card.toFileName() + ".json"), card);
//
//        Logger.log(Logger.LogType.JSON_MAKER, "JSON File created at: " + path + "\\" + card.toFileName() + ".json");
//
//        return path;
//    }
//
//
//    // key should be any string of characters before the "
//    // For example:  "cardNumber":"37a"  should have the key as cardNumber and no "
//    public static String pullMakerStat(String source, String key) {
//        if (source == "" || source == null || key == null) {return null;}
//        boolean isValueFound = false;
//        String returnedString = "";
//
//        for (char currChar : source.substring(source.indexOf(key) + key.length()).toCharArray()) {
//            if (currChar != '\"' && currChar != ':') {
//                returnedString = returnedString + currChar;
//                isValueFound = true;
//            } else if (isValueFound) {
//                return returnedString;
//            }
//        }
//        return returnedString;
//    }
//
//
//    // Uses the String source of a pokecardmaker page and returns an array of Card objects
//    public static Card[] sourceToCardList(String source) throws Exception {
//
//        // Returns null if source is null
//        if (source == null) {return null;}
//
//        // The ArrayList of Cards to be converted into a Card[] to be returned
//        List<Card> cardList = new ArrayList<Card>();
//
//        // Temporary variables for iteration
//        Card tempCard;
//        String tempSlug = "";
//
//        while (source.contains("slug")) {
//            tempSlug = pullMakerStat(source, "slug");
//            // Converts tempSlug to a valid maker url, gets the url's source, and saves that source as a card
//            tempCard = sourceToCard(getURLSource(slugToMakerURL(tempSlug, "SaylorMay")));
//            if (tempCard != null && tempCard.getName() != null) {cardList.add(tempCard);}
//            source = source.replaceFirst("slug", "");
//        }
//
//        // Converts the ArrayList to a Card[] array
//        return cardList.toArray(new Card[cardList.size()]);
//    }
//
//
//// ----------------------------- UTILITY METHODS ------------------------------------ //
//
//
//    // Safely converts a String to an int
//    public static int StringToInt(String string) {
//        if (string == null) {return 0;}
//        try {
//            return Integer.valueOf(string);
//        }
//        catch (NumberFormatException e) {
//            return 0;
//        }
//    }
//
//
//    // Gives an int superType to a readable String
//    // superType = 1: Pokémon
//    // superType = 2: Trainer
//    // superType = 3: Energy
//    public static String superTypeToString(int superType) {
//        switch(superType) {
//            case 1:
//                return "Pokémon";
//
//            case 2:
//                return "Trainer";
//
//            case 3:
//                return "Energy";
//        }
//
//        Logger.log(Logger.LogType.WARN, "Returned a blank String, invalid superType of " + superType, "Conversion.superTypeToString()");
//
//        return "";
//    }
//
//
//    // 0) Custom
//    // 1) Grass
//    // 2) Fire
//    // 3) Water
//    // 4) Lightning
//    // 5) Psychic
//    // 6) Fighting
//    // 7) Dark
//    // 8) Metal
//    // 9) Fairy
//    // 10) Dragon
//    // 11) Colorless
//    // 12) Item
//    // 13) Supporter
//    // 14) Stadium
//    // 15) Base
//    // 16) Special
//    // 17) Tool
//    public static String typeIdToString(int typeID) {
//
//        if (typeID > 17 || typeID < 0) {return null;}
//
//        String[] temp = {
//                "Custom",   // 0
//                "Grass",    // 1
//                "Fire",     // 2
//                "Water",    // 3
//                "Lightning",// 4
//                "Psychic",  // 5
//                "Fighting", // 6
//                "Dark",     // 7
//                "Metal",    // 8
//                "Fairy",    // 9
//                "Dragon",   // 10
//                "Colorless",// 11
//                "Item",     // 12
//                "Supporter",// 13
//                "Stadium",  // 14
//                "Base",     // 15
//                "Special",  // 16
//                "Tool"      // 17
//        };
//
//        return temp[typeID];
//    }
//
//
//    // BASIC="1",t.STAGE_1="2",t.STAGE_2="3",t.RESTORED="21",t.V="4",t.V_MAX="5",t.V_STAR="6",t.TOOL="7",t.GX_BASIC="8",t.GX_STAGE_1="9",t.GX_STAGE_2="10",t.GX_TAG_TEAM="11",t.LV_X="12",t.EX_BASIC="13",t.EX_STAGE_1="14",t.EX_STAGE_2="15",t.EX_XY_BW="16",t.MEGA="17",t.EX_MEGA_BASIC="18",t.EX_MEGA_STAGE_1="19",t.EX_MEGA_STAGE_2="20",t.BREAK="22"
//    public static String subTypeToStage(int subType) {
//        return null;
//    }
//
//
//    // Converts and returns an html version that can be safely interpreted in Java
//    public static String toSafeLink(String url) {
//        Logger.log(Logger.LogType.TESTING, "toSafeLink was used, but doesn't currently do anything!");
//        return url;
//    }
//
//
//    // Takes a .txt file and returns a String containing every line
//    public static String readTxtFile(File file) throws Exception {
//
//        String source = "";
//        for (String line : Files.readAllLines(file.toPath())) {
//            source = source + line;
//        }
//        return source;
//    }
//
//    // Converts a slug to a pokecardmaker url
//    // The user parameter should be exactly what the same as other urls on pokecardmaker
//    public static String slugToMakerURL(String slug, String user) {
//        return "https://pokecardmaker.net/card/" + user + "/" + slug;
//    }
//
//    // Converts a slug to the corresponding image URL on pokecardmaker
//    public static String slugToImageURL(String slug, String user) {
//        return "https://pokecardmaker.net/card/" + user + "/" + toSafeLink(slug);
//    }
//
//
//    //
//    public static String interpSuperType(String response) {
//        if (response == null || response.length() == 0) {
//            System.out.println("Couldn't interpret the supertype of " + response);
//            return "";
//        }
//        switch(response.toLowerCase().charAt(0)) {
//            case 's':
//                return "Trainer";
//            case 't':
//                return "Trainer";
//            case 'i':
//                return "Trainer";
//            case 'e':
//                return "Energy";
//            case 'p':
//                return "Pokemon";
//        }
//        System.out.println("Couldn't interpret the supertype of " + response);
//        return "";
//    }
//}