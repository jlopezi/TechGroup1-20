package jalasoft.training;

public class RocketSpaceShip implements ISpaceShip {
    protected int cost;
    protected int rocketWeight;
    protected int maxWeight;
    protected int cargoWeight;
    protected double launchExplosionIndex;
    protected double landingCrashIndex;


    public boolean launch() {
        double randomThreshold = Math.random();
        double launchExplosionChance = launchExplosionIndex * ((double) cargoWeight / (maxWeight - rocketWeight));
        if (launchExplosionChance > randomThreshold) {
            return false;
        }
        return true;
    }

    public boolean land() {
        double randomThreshold = Math.random();
        double landingCrashChance = landingCrashIndex * ((double)cargoWeight / (maxWeight - rocketWeight));
        if (landingCrashChance > randomThreshold) {
            return false;
        }
        return true;
    }

    public boolean canCarry(Item item) {
        if ((item.getWeight() + (rocketWeight + cargoWeight)) <= maxWeight)
            return true;
        return false;
    }

    public void carry(Item item) {
        cargoWeight += item.getWeight();
    }
}
