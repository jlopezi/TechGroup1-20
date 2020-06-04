/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package antoniorojas.mission;

public class Rocket implements SpaceShip {
    private double weight;
    private double maxWeight;
    private int cost;

    public Rocket(double weight, double maxWeight, int cost) {
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getCost() {
        return cost;
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
        weight = weight + item.getWeight();
    }
}
