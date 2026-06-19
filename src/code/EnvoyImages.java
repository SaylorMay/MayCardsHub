package code;

public class EnvoyImages {
    public String small = "";
    public String large = "";

    public EnvoyImages(String imageUrl) {
        small = imageUrl;
        large = imageUrl;
    }

    public EnvoyImages() {
        small = "";
        large = "";
    }
}