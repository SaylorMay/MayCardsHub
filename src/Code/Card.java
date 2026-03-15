package Code;

public class Card {

    // The
    private String name;
    private int hp = 0;
    private String gitImgURL;
    private String makerImgURL;
    private String superType;
    private Set set;
    private String setID;
    private String cardNum;
    private String[] subTypes;
    
    public Card() {
        name = "";
        hp = 0;
        gitImgURL = "";
        makerImgURL = "";
        superType = "";
        set = null;
        setID = "";
        cardNum = "";
        subTypes = null;
    }

    public Card(String name, int hp, String gitImgURL, String makerImgURL, String superType, Set set, String setID, String idNum, String[] subTypes) {
        this.name = name;
        this.hp = hp;
        this.gitImgURL = gitImgURL;
        this.makerImgURL = makerImgURL;
        this.superType = superType;
        this.set = set;
        this.setID = setID;
        this.cardNum = idNum;
        this.subTypes = subTypes;
    }

    // ToString
    @Override
    public String toString() {
        return name + ", " +
                hp + ", " +
                gitImgURL + "," +
                makerImgURL + "," +
                superType + "," +
                set + "," +
                setID + ", " +
                cardNum + "," +
                subTypes;
    }


    // Getter and Setter Methods
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getHp() {return hp;}
    public void setHp(int hp) {this.hp = hp;}
    public String getGitImgURL() {return gitImgURL;}
    public void setGitImgURL(String gitImgURL) {this.gitImgURL = gitImgURL;}
    public String getMakerImgURL() {return makerImgURL;}
    public void setMakerImgURL(String makerImgURL) {this.makerImgURL = makerImgURL;}
    public String getSuperType() {return superType;}
    public void setSuperType(String superType) {this.superType = superType;}
    public Set getSet() {return set;}
    public void setSet(Set set) {this.set = set;}
    public String getSetID() {return setID;}
    public void setSetID(String setID) {this.setID = setID;}
    public String getCardNum() {return cardNum;}
    public void setCardNum(String cardNum) {this.cardNum = cardNum;}
    public String[] getsubTypes() {return subTypes;}
    public void setsubTypes(String[] subTypes) {this.subTypes = subTypes;}

}
