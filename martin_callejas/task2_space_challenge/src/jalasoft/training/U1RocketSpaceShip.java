package jalasoft.training;

public class U1RocketSpaceShip extends RocketSpaceShip {
    public U1RocketSpaceShip(){
        this.cost = 100;
        this.rocketWeight = 10 * 1000;
        this.maxWeight = 18 * 1000;
        this.launchExplosionIndex = 0.05;
        this.landingCrashIndex = 0.01;
    }
}
