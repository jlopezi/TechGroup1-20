public class Rocket implements SpaceShip {

    protected int cost;
    protected int weight;
    protected int capacity;

    public boolean launch() {
        // if the launch was successful true
        return true;
    }

    public boolean land() {
        // if the launch was successful true
        return true;
    }

    public boolean canCarry(Item item) {
        // if can carry an Item, implementation here
        if((weight + item.getWeight()) <= capacity ){
            return true;
        }
        return false;
    }

    public void carry(Item item) {
        // Modifies the weight of the rocket, implementation here
            weight = weight + item.getWeight();
    }
}
