package code;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonPropertyOrder({
        "id",
        "name",
        "supertype",
        "isCustom",
        "image",
        "imageUrl",
        "images",
        "subtypes",
        "types",
        "hp",
        "evolvesFrom",
        "customSetName",
        "setNumber",
        "number",
        "set",
        "attacks",
        "abilities",
        "weaknesses",
        "resistances",
        "retreatCost",
        "convertedRetreatCost",
        "artist",
        "rarity",
        "flavorText",
        "legalities",
        "forteData",
        "rules",
        "created",
        "importOrder"
})

public class EnvoyCard {
    public String id = "";
    public String name = "";
    public String supertype = "";
    public boolean isCustom = true;

    public String image = "";
    public String imageUrl = "";
    public EnvoyImages images = new EnvoyImages();

    public List<String> subtypes = new ArrayList<>();
    public List<String> types = new ArrayList<>();

    public String hp = "0";
    public String evolvesFrom = "";

    public String customSetName = "";
    public String number = "";
    public String set = "";

    // Don't use pls
    public Integer setNumber = null;

    public List<Object> attacks = new ArrayList<>();
    public List<Object> abilities = new ArrayList<>();
    public List<Object> weaknesses = new ArrayList<>();
    public List<Object> resistances = new ArrayList<>();

    public List<String> retreatCost  = new ArrayList<>();
    public int convertedRetreatCost = 0;

    public String artist = "";
    public String rarity = "";
    public String flavorText = "";

    public EnvoyFormats legalities = new EnvoyFormats();

    public Map<String, Object> forteData =  new HashMap<>();

    public List<String> rules = new ArrayList<>();

    public String created = "";

    public int importOrder = 0;

    public EnvoyCard(String name, String number, String set, String imageUrl, String id, String hp, String supertype, String created, int importOrder) {
        this.name = name;
        this.number = number;
        this.set = set;
        this.image = imageUrl;
        this.imageUrl = imageUrl;
        this.images = new EnvoyImages(imageUrl);
        this.id = id;
        this.hp = hp;
        this.supertype = supertype;
        this.created = created;
        this.importOrder = importOrder;
    }
}