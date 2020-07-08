package main.java;

import java.util.Random;

/**
 * main.java.Rocket class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Rocket implements SpaceShip {
    protected int cost;
    protected int maxWeight;
    protected int weight;

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

    /**
     * Is explosion method use the probability equation,
     * to know whether a explosion occur.
     * @param percent help us to calculate 'Number of Favorable Outcome'.
     * @param totalNumberOfFavorable is a variable to calculate the Probability.
     * @return true if we going well on the land, otherwise false.
     */
    protected boolean isExplosion(double percent, double totalNumberOfFavorable) {
        //Probability = Number of Favorable Outcome / Total Number of Favorable outcomes
        //Number of Favorable Outcome = percent * (cargo carried / cargo limit)
        double numberOfFavorableOutcome = percent * ((double)weight
                                                    / (double)maxWeight);
        return (numberOfFavorableOutcome / totalNumberOfFavorable) >= 1.0;
    }
}
