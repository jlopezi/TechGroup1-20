package main.java.com.tech_group;

/**
 * Class to represent U1 rocket object.
 */
public class U1 extends Rocket{

    private final static int COST = 100;
    // Each line in the file contains the item name as well as its WEIGHT in Kgs. 10 Tonnes = 10000 Kgs
    private final static double WEIGHT = 10000;
    private final static double MAX_WEIGHT = 18000;

    /**
     * U1 rocket constructor.
     */
    public U1() {
        super(COST, WEIGHT, MAX_WEIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean launch(){
        double random = Math.random();
        return (0.05 * (WEIGHT / MAX_WEIGHT)) < random;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean land(){
        double random = Math.random();
        return (0.01 * (WEIGHT / MAX_WEIGHT)) < random;
    }
}