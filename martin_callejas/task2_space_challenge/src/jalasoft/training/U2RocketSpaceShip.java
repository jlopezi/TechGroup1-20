package jalasoft.training;

public class U2RocketSpaceShip extends RocketSpaceShip {
    public U2RocketSpaceShip(){
        this.cost = 120;
        this.rocketWeight = 18 * 1000;
        this.maxWeight = 29 * 1000;
        this.launchExplosionIndex = 0.04;
        this.landingCrashIndex = 0.08;
    }
}
