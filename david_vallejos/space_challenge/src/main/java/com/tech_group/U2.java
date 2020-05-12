package main.java.com.tech_group;

/**
 * Class to represent U2 rocket object.
 */
public class U2 extends Rocket {

    private final static int cost = 120;
    // Each line in the file contains the item name as well as its weight in Kgs. 10 Tonnes = 10000 Kgs
    private final static int weight = 18000;
    private final static int maxWeight = 29000;

    /**
     * U1 rocket constructor.
     */
    public U2() {
        super(cost, weight, maxWeight);
    }

    @Override
    public boolean launch(){
        double random = Math.random();
        return random > (0.04 * (weight / maxWeight));
    }

    @Override
    public boolean land(){
        double random = Math.random();
        return random > (0.08 * (weight / maxWeight));
    }
}