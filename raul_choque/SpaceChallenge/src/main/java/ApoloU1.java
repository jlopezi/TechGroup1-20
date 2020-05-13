package main.java;

/**
 * ApoloU1 class.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ApoloU1 extends Rocket {
    private static final int COST = 100;
    private static final int MAX_WEIGHT = 18;
    private double chanceOfLandingCrash = 0.01;
    private double chanceOfLaunchExplosion = 0.05;
    private static int weight = 10;

    public ApoloU1() {
        super(COST, MAX_WEIGHT, weight);
    }

    /**
     * Lands method calculate corresponding chance of exploding.
     * @return true if we going well on the land, otherwise false.
     */
    @Override
    public boolean land() {
        return Math.random() > (chanceOfLandingCrash
                * ((double)super.getWeight()/(double) MAX_WEIGHT));
    }

    /**
     * Launches method calculate corresponding chance of exploding.
     * @return true if we going well on the launch, otherwise false.
     */
    @Override
    public boolean launch() {
        return Math.random() > (chanceOfLaunchExplosion
                * ((double)super.getWeight()/(double) MAX_WEIGHT));
    }

    public void setChanceOfLandingCrash(double chanceOfLandingCrash) {
        this.chanceOfLandingCrash = chanceOfLandingCrash;
    }

    public void setChanceOfLaunchExplosion(double chanceOfLaunchExplosion) {
        this.chanceOfLaunchExplosion = chanceOfLaunchExplosion;
    }
}
