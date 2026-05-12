package Code;

import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;

public class TesseractTest {

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                baseWindow window = new baseWindow();
                window.setVisible(true);
            }
        });


        try {
            final String unsortedPath = "C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\Assets\\Unsorted\\";

            String imagePath1 = unsortedPath + "poppy-s-playtim-1770002153296-bdcff508-4b24-41f5-b1a2-73f294.png";
            String imagePath2 = unsortedPath + "penny-s-aura-fa-1767950163695-0a9d9907-a0b4-4ecf-8ad3-73a573.png";
            String imagePath3 = unsortedPath + "phonky-donky-te-1770841716711-e1a3f80a-f809-401d-ba3c-f8ccf9.png";
            String imagePath4 = unsortedPath + "oshawott-1767667040215-f832bece-35cb-423d-bf20-45158860a7dd.png";
            String imagePath5 = "C:\\Users\\Saylo\\Downloads\\ASC_264_R_EN.png";

            //ImageIO.write(ImageIO.read(new File(imagePath2)).getSubimage(82, 653, 77, 26), "png", new File("crop1.png"));
            ImageIO.write(ImageIO.read(new File(imagePath1)).getSubimage(30, 50, 400, 40), "png", new File("crop2.png"));
            //ImageIO.write(new java.awt.image.BufferedImage(154,52,java.awt.image.BufferedImage.TYPE_BYTE_GRAY){{getGraphics().drawImage(ImageIO.read(
                    //new File(imagePath5)).getSubimage(82,653,77,26),0,0,154,52,null);}}, "png", new File("crop1.png"));

            //ProcessBuilder processBuild = new ProcessBuilder("C:\\Program Files\\Tesseract-OCR\\tesseract.exe", "crop1.png", "stdout");
            ProcessBuilder processBuild = new ProcessBuilder(
                    "C:\\Program Files\\Tesseract-OCR\\tesseract.exe",
                    "crop2.png",
                    "stdout",
                    "--psm",
                    "7"
                    //"-l",
                    //"eng"
            );

            Process process = processBuild.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}