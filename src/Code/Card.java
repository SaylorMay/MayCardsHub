package Code;

public class Card {

    // The actual printed name of the card
    private String name;

    // The health points of the card
    private int hp = 0;

    // The url pointer to the corresponding catbox image
    private String imageURL;

    // Pokemon, Energy, Item, Supporter, Stadium, Tool, Misc
    private String superType;

    // The number of the card, so like 5a or 3
    private String cardNum;

    // The set, so like UtDr or Hyo
    private String set;

    // What type of Rule Box it is
    private String ruleBox = "";

    // Basic, Stage1, Stage2, Archon
    private String stage = "";

    // Elemental Type
    private String element = "";

    // Where the most recent version was created (Maker or Generator)
    private String source = "";

    // Just the subType because why not
    private int subType = 0;
    
    public Card() {
        name = "";
        hp = 0;
        imageURL = "";
        superType = "";
        cardNum = "";
        set = "";
        ruleBox = "";
        stage = "";
        element = "";
        source = "";
        subType = 0;
    }

    public Card(String name, int hp, String imageURL, String superType, String cardNum, String set, String ruleBox, String stage, String element, String source, int subType) {
        this.name = name;
        this.hp = hp;
        this.imageURL = imageURL;
        this.superType = superType;
        this.cardNum = cardNum;
        this.set = set;
        this.ruleBox = ruleBox;
        this.stage = stage;
        this.element = element;
        this.source = source;
        this.subType = subType;
    }

    // ToString
    @Override
    public String toString() {
        return "\nName: " + name +
                "\nHP: " + hp +
                "\nImageURL: " + imageURL +
                "\nSuperType: " + superType +
                "\nCard ID: " + cardNum + "/" + set +
                "\nRule Box: " + ruleBox +
                "\nElement: " + element +
                "\nSource: " + source +
                "\nSubType: " + subType + "\n";
    }


    // Getter and Setter Methods
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp = hp;}

    public String getImageURL() {return imageURL;}
    public void setImageURL(String imageURL) {this.imageURL = imageURL;}

    public String getSuperType() {return superType;}
    public void setSuperType(String superType) {this.superType = superType;}
    //public boolean isTrainer() {return superType == "Trainer" || superType == "Supporter" || superType == "Item" ||  superType == "Tool" ||  superType == "Stadium";}

    public String getCardNum() {return cardNum;}
    public void setCardNum(String cardNum) {this.cardNum = cardNum;}
    public String getFullID() {return cardNum + "/" + set;}

    public String getSet() {return set;}
    public void setSet(String set) {this.set = set;}

    public String getRuleBox() {return ruleBox;}
    public void setRuleBox(String ruleBox) {this.ruleBox = ruleBox;}

    public String getStage() {return stage;}
    public void setStage(String stage) {this.stage = stage;}
    //public boolean isBasic() {return stage == "Basic";}
    //public boolean isStage1() {return stage == "Stage1";}
    //public boolean isStage2() {return stage == "Stage2";}
    //public boolean isArchon() {return stage == "Archon";}

    public String getElement() {return element;}
    public void setElement(String element) {this.element = element;}

    public String getSource() {return source;}
    public void setSource(String source) {this.source = source;}
    //public boolean isGenerator() {return source == "PokecardGenerator";}
    //public boolean isMaker() {return source == "PokecardMaker";}

    public int getSubType() {return subType;}
    public void setSubType(int subType) {this.subType = subType;}


    // Returns an identifying name to name a file for this card
    public String toFileName() {return set + "-" + cardNum + " " + name;}
}