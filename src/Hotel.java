public class Hotel {
    private int id;
    private String name;
    private String location;

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Hotel(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
