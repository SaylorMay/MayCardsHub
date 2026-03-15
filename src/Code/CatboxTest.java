package Code;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class CatboxTest {

    public static void main(String[] args) throws Exception {

        // File you want to upload
        File file = new File("C:\\Users\\Saylo\\Desktop\\IntelliJ Projects\\Pokemon\\MayCardsHub\\src\\Assets\\Unsorted\\alouette.png");

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

        // -----------------------------
        // 1. Request type
        // -----------------------------
        writer.println("--" + boundary);
        writer.println("Content-Disposition: form-data; name=\"reqtype\"");
        writer.println();
        writer.println("fileupload");

        // -----------------------------
        // 2. Add your account userhash
        // -----------------------------
        writer.println("--" + boundary);
        writer.println("Content-Disposition: form-data; name=\"userhash\"");
        writer.println();
        writer.println(userhash);

        // -----------------------------
        // 3. Upload the file
        // -----------------------------
        writer.println("--" + boundary);
        writer.println("Content-Disposition: form-data; name=\"fileToUpload\"; filename=\"" + file.getName() + "\"");
        writer.println("Content-Type: " + Files.probeContentType(file.toPath()));
        writer.println();
        writer.flush();

        // Send file data
        Files.copy(file.toPath(), output);
        output.flush();

        // End multipart request
        writer.println();
        writer.println("--" + boundary + "--");
        writer.close();

        // -----------------------------
        // 4. Read response (URL of upload)
        // -----------------------------
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        String response = reader.readLine();

        System.out.println("Uploaded file URL: " + response);
    }
}