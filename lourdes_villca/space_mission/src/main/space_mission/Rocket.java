/*
 * Copyright (c) 2020. Jalasoft SRL
 */

package space_mission;

/**
 * Class that manage if a rocket can carry or not items
 */
public class Rocket implements SpaceShip {
    protected int cost;
    protected int weight;
    protected int maxWeight;
    protected int currentWeight;

    /**
     * Constructor that set initial values.
     *
     * @param cost      Rocket cost.
     * @param weight    Rocket Weight.
     * @param maxWeight Rocket max weight.
     */
    public Rocket(int cost, int weight, int maxWeight) {
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.currentWeight = weight;
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
        currentWeight = currentWeight + item.getWeight();
        return currentWeight < maxWeight;
    }

    @Override
    public void carry(Item item) {
        currentWeight = item.getWeight() + currentWeight;
    }
}
