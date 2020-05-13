package com.tech_group.space_challenge;

import java.util.Random;

/**
 * Represents a U1 Rocket object.
 */
public class U1 extends Rocket {
    private static final Double COST;
    private static final Double INITIAL_WEIGHT;
    private static final Double MAX_WEIGHT;

    static {
        COST = 100000.0;
        INITIAL_WEIGHT = 10000.0;
        MAX_WEIGHT = 18000.0;
    }

    /**
     * Creates and initializes a U1 Rocket.
     */
    public U1() {
        super(COST, INITIAL_WEIGHT, MAX_WEIGHT);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean launch() {
        changeToSurviveExplosion = new Random().nextDouble();
        return changeToSurviveExplosion > 0.05 * (super.getWeight() / MAX_WEIGHT);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean land() {
        changeToSurviveExplosion = new Random().nextDouble();
        return changeToSurviveExplosion > 0.01 * (super.getWeight() / MAX_WEIGHT);
    }
}
