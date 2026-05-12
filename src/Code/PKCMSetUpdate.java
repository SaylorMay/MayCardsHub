package Code;

public class PKCMSetUpdate {

    public static void main(String[] args) throws Exception {
        String setURL = "https://pokecardmaker.net/set/SaylorMay/vocaloid-9d008im";
        String folderPath = "";

        Card[] cardList = Conversion.sourceToCardList(Conversion.getURLSource(setURL));
        //Conversion.

        for (Card card : cardList) {
            System.out.println(card);
        }
    }



}
