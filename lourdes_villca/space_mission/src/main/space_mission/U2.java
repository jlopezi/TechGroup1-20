/*
 * Copyright (c) 2020. Jalasoft SRL
 */

package space_mission;

/**
 * Class that represent the Rocket U2
 */
public class U2 extends Rocket {
    private final static int COST = 120; //Rocket cost in millions
    private final static int WEIGHT = 18000; //Rocket weight in kilograms
    private final static int MAX_WEIGHT = 29000; // Max weight (with cargo)

    /**
     * Constructor that initialize values
     */
    U2() {
        super(COST, WEIGHT, MAX_WEIGHT);
    }

    @Override
    public boolean launch() {
        double random = Math.random();
        return random > (0.04 * (double) (super.weight / super.maxWeight));
    }

    @Override
    public boolean land() {
        double random = Math.random();
        return random > (0.08 * (double) (super.weight / super.maxWeight));
    }

}
