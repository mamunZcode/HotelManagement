abstract class Room {
    private String name;

    public Room() {
        this.name = "empty";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}