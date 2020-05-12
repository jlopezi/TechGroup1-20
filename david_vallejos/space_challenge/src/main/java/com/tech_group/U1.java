package main.java.com.tech_group;

/**
 * Class to represent U1 rocket object.
 */
public class U1 extends Rocket{

    private final static int cost = 100;
    // Each line in the file contains the item name as well as its weight in Kgs. 10 Tonnes = 10000 Kgs
    private final static int weight = 10000;
    private final static int maxWeight = 18000;

    /**
     * U1 rocket constructor.
     */
    public U1() {
        super(cost, weight, maxWeight);
    }

    @Override
    public boolean launch(){
        double random = Math.random();
        return (0.05 * (weight / maxWeight)) > random;
    }

    @Override
    public boolean land(){
        double random = Math.random();
        return (0.01 * (weight / maxWeight)) > random;
    }
}