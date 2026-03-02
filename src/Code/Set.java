package Code;

public class Set {

    // The name that all images in here should be contained in
    private String name = "";
    // The start of the signifier as to which set it belongs to
    private String id = "";

    public Set(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getter/Setter methods for name
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    //Getter/setter methods for id
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
}
