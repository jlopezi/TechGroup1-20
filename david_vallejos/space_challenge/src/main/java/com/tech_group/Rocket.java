package main.java.com.tech_group;

/**
 * Class to represent Rocket object.
 */
public class Rocket implements SpaceShip{

    private int cost;
    private double weight;
    private double maxWeight;

    /**
     * Rocket constructor.
     * @param cost of the rocket.
     * @param weight of the rocket.
     * @param maxWeight of the rocket.
     */
    public Rocket(int cost, double weight, double maxWeight){
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return weight + item.getWeight() <= maxWeight;
    }

    @Override
    public void carry(Item item) {
        weight += item.getWeight();
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}