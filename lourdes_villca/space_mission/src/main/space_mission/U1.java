/*
 * Copyright (c) 2020. Jalasoft SRL
 */

package space_mission;

/**
 * Class that represent the Rocket U1.
 */
public class U1 extends Rocket {
    private final static int COST = 100; //Rocket cost
    private final static int WEIGHT = 10000; //Rocket weight in Kilograms
    private final static int MAX_WEIGHT = 18000; // Max weight (with cargo)

    /**
     * Constructor that initialize attributes.
     */
    public U1() {
        super(COST, WEIGHT, MAX_WEIGHT);
    }

    @Override
    public boolean launch() {
        double random = Math.random();
        return random > (0.05 * (double) (super.currentWeight / super.maxWeight));
    }

    @Override
    public boolean land() {
        double random = Math.random();
        return random > (0.01 * (double) (super.currentWeight / super.maxWeight));
    }
}
