package Code;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class webScrapeTest1 {

    public static void main(String[] args) throws Exception {
        // Example: Extracting title and links
        Document doc = Jsoup.connect("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html").get(); //
        String title = doc.title(); //
        Elements links = doc.select("a[href]"); //
    }
}
