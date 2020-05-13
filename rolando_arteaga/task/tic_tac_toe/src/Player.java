public class Player {
    private final String playerNumber;
    private String name;
    private String color;

    public Player(String playerNumber, String color) {
        this.color = color;
        this.playerNumber = playerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }
}
