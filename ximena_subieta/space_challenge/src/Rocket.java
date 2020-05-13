/**
 * This is the class Rocket that implements SpaceShip
 */
public class Rocket implements SpaceShip {

    protected int cost;
    protected int weight;
    protected int maxWeight;
    protected double launchExplosion;
    protected double landingCrash;
    protected int currentWeight;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return this.currentWeight + item.weight <= maxWeight;
    }

    public int carry(Item item) {
        this.currentWeight += item.weight;
        return this.currentWeight;
    }
}
