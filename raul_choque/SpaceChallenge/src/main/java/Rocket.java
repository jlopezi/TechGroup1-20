package main.java;

/**
 * main.java.Rocket class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Rocket implements SpaceShip {
    private int cost;
    private int maxWeight;
    private int weight;

    public Rocket(int cost, int maxWeight, int weight) {
        this.cost = cost;
        this. maxWeight = maxWeight;
        this.weight= weight;
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
    public final boolean canCarry(Item item) {
        return (this.weight + item.getWeight()) <= maxWeight;
    }

    @Override
    public final void carry(Item item) {
        if (canCarry(item)) {
            weight += item.getWeight();
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCost() {
        return cost;
    }
}
