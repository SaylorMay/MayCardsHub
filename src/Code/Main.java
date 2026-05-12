package Code;

import javax.swing.*;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        baseWindow window = new baseWindow();
        window.setVisible(true);

        ImageProcessor process = new ImageProcessor();

        String setFolder = "Akari";
        String setID = "Akr";

        File newFile;

        File folder = new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\UnprocessedImages\\" + setFolder);

        //process.setToProcess(process.getEveryFile(folder));
        File[] tempFiles = {
                new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\UnprocessedImages\\Akari\\arceus-1768517436168-1c734e39-cfa9-4d28-9644-da3b3b5e4ba0.png")
        };
        process.setToProcess(tempFiles);

        String url = "";

        for (int i = 0; i < process.getToProcess().length; i++) {

            window.getButton1().setIcon(new ImageIcon(process.getToProcess()[i].getAbsolutePath()));

            // Waits until baseWindow sends a request
            while (!ImageProcessor.isContinueRequest()) {
                Thread.sleep(500);
            }
            ImageProcessor.setContinueRequest(false);

            Card tempCard = new Card(
                    window.getFormattedTextField1().getText(),
                    0,
                    "",
                    Conversion.interpSuperType(window.getFormattedTextField2().getText()),
                    window.getFormattedTextField3().getText(),
                    setID,
                    "",
                    "",
                    "",
                    "PokeCardGenerator",
                    0
            );

            window.getButton1().setIcon(null);

            newFile = new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\ProcessedImages\\" + setFolder + "\\" + tempCard.toFileName() + ".png");

            if (process.getToProcess()[i].renameTo(newFile)) {
                System.out.println("Renamed to " + newFile.getName());
            }

            tempCard.setImageURL(CatboxTest.fileToCatbox(newFile));

            System.out.println("Card uploaded to: " + tempCard.getImageURL());


            Conversion.cardToJSON(tempCard, "C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\Cards\\" + setFolder + "\\" + tempCard.toFileName() + ".json");


            System.out.println(process.getToProcess()[i].getName());
        }

        //File image = new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\UnprocessedImages\\Akari\\arceus-1768517436168-1c734e39-cfa9-4d28-9644-da3b3b5e4ba0.png");
        //image.renameTo(new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\UnprocessedImages\\Akari\\Arceus.png"));
        //window.getButton1().setIcon(new ImageIcon("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\Assets\\Akari\\akari-1768347668719-cd6bb674-16d0-40bc-8a6a-cdd79e8cb22a.png"));

    }
}