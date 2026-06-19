package code;

// Holds all the information on a specific card
public class Card {

    // The Main Display Name
    private String name = "";
    // The name before the main name (Blanche's, Akari's, Ringmaster, etc.)
    // Pokecardmaker counts the subtext to the right as prefixes.  This doesn't include that
    private String prefix = "";

    // The ID for the card within their set (31a, 5Y, 73, etc.)
    private String idNum = "";

    // The 3-4 letter ID for the set the card is apart of (Bla, Hyo, JuPk, Akr, etc.)
    private String setId = "";

    // The link to the image on wherever it's hosted
    private String imageLink = "";

    // The link to its PokeCardMaker.net page
    private String pokeMakerLink = "";

    // HP (Default of 0)
    private String hp = "0";

    // Either a Pokémon (1), Trainer (2), or Energy (3)
    private String superType = "";

    // Date the card was originally created
    private String creationDate = "";

    // Constructor with only the essential aspects to play with it
    public Card(String name, String prefix, String idNum, String setId, String imageLink) {
        this.name = name;
        this.prefix = prefix;
        this.idNum = idNum;
        this.setId = setId;
        this.imageLink = imageLink;
    }

    // Constructor with every parameter
    public Card(String name, String prefix, String idNum, String setId, String imageLink, String pokeMakerLink,  String hp, String superType, String creationDate) {
        this.name = name;
        this.prefix = prefix;
        this.idNum = idNum;
        this.setId = setId;
        this.imageLink = imageLink;
        this.pokeMakerLink = pokeMakerLink;
        this.hp = hp;
        this.superType = superType;
        this.creationDate = creationDate;
    }

    // Get methods for each variable
    public String getName() {return name;}
    public String getPrefix() {return prefix;}
    public String getIdNum() {return idNum;}
    public String getSetId() {return setId;}
    public String getImageLink() {return imageLink;}
    public String getPokeMakerLink() {return pokeMakerLink;}
    public String getHp() {return hp;}
    public String getSuperType() {return superType;}
    public String getCreationDate() {return creationDate;}

    // Set methods for each variable
    public void setName(String name) {this.name = name;}
    public void setPrefix(String prefix) {this.prefix = prefix;}
    public void setIdNum(String idNum) {this.idNum = idNum;}
    public void setSetId(String setId) {this.setId = setId;}
    public void setImageLink(String catBoxImgLink) {this.imageLink = imageLink;}
    public void setPokeMakerLink(String pokeMakerLink) {}
    public void setHp(String hp) {this.hp = hp;}
    public void setSuperType(String superType) {this.superType = superType;}
    public void setCreationDate(String creationDate) {this.creationDate = creationDate;}


    public String toString() {
        return "Name: " + name +
                "\nPrefix: " + prefix +
                "\nID Number: " + idNum +
                "\nSet ID: " + setId +
                "\nImage Link: " + imageLink +
                "\nPokeCardMaker Link: " + pokeMakerLink +
                "\nHP: " + hp +
                "\nSuperType: " + superType;
    }
}
