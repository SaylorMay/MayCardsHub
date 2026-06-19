package archivedCode;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class CatboxTest {

    public static void main(String[] args) throws Exception {
        fileToCatbox(new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\ProcessedImages\\Akari\\Akr-6a Akari' Arceus.png"));
    }

    public static String fileToCatbox(File file) throws Exception {
        // File you want to upload
        // file = new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\Assets\\Unsorted\\Furina.png");

        // Your Catbox userhash (from your Catbox account page)
        String userhash = "3e2a7090e4fecd13fc265a806";

        // Catbox API endpoint
        URL url = new URL("https://catbox.moe/user/api.php");

        String boundary = "----CatboxBoundary";

        // Open connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Tell server we're sending multipart form data
        conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

        OutputStream output = conn.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(output), true);

        // Request type
        writer.println("--" + boundary);
        writer.println("Content-Disposition: form-data; name=\"reqtype\"");
        writer.println();
        writer.println("fileupload");

        // Specify userhash
        writer.println("--" + boundary);
        writer.println("Content-Disposition: form-data; name=\"userhash\"");
        writer.println();
        writer.println(userhash);

        // Upload
        writer.println("--" + boundary);
        writer.println("Content-Disposition: form-data; name=\"fileToUpload\"; filename=\"" + file.getName() + "\"");
        writer.println("Content-Type: " + Files.probeContentType(file.toPath()));
        writer.println();
        writer.flush();

        // Send file data
        Files.copy(file.toPath(), output);
        output.flush();

        // End request
        writer.println();
        writer.println("--" + boundary + "--");
        writer.close();

        // Print new url
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        String response = reader.readLine();

        System.out.println("Uploaded file URL: " + response);

        return response;

    }
}