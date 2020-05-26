/**
 * Class to represent U2 rocket object.
 */
public class U2 extends Rocket {

    private final static int COST = 120;
    // Each line in the file contains the item name as well as its WEIGHT in Kgs. 10 Tonnes = 10000 Kgs
    private final static double WEIGHT = 18000;
    private final static double MAX_WEIGHT = 29000;

    /**
     * U1 rocket constructor.
     */
    public U2() {
        super(COST, WEIGHT, MAX_WEIGHT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean launch(){
        double random = Math.random();
        return random > (0.04 * (WEIGHT / MAX_WEIGHT));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean land(){
        double random = Math.random();
        return random > (0.08 * (WEIGHT / MAX_WEIGHT));
    }
}