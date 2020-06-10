package com.tech_group.space_challenge;

/**
 * Represents a Rocket object.
 */
public class Rocket implements SpaceShip {
    private final Double maxWeight;
    private final Double cost;
    public Double changeToSurviveExplosion;
    private Double weight;

    /**
     * Creates and initializes a Rocket object.
     *
     * @param cost      represents the money invested to build a rocket.
     * @param weight    represents the total weight a rocket is currently transporting.
     * @param maxWeight represents the maximum amount of Items a rocket can transport.
     */
    public Rocket(final Double cost, final Double weight, final Double maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
        changeToSurviveExplosion = 0.0;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean canCarry(final Item item) {
        return this.weight + item.getWeight() < this.maxWeight;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void carry(final Item item) {
        this.weight += item.getWeight();
    }

    /**
     * Gets the weight attribute.
     *
     * @return weight attribute as Double.
     */
    public Double getWeight() {
        return this.weight;
    }

    /**
     * Gets the cost attribute.
     *
     * @return cost attribute as Double.
     */
    public Double getCost() {
        return cost;
    }
}
