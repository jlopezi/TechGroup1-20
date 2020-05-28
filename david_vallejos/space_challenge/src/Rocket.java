/**
 * Class to represent Rocket object.
 */
public class Rocket implements SpaceShip{

    private int cost;
    private double weight;
    private double maxWeight;

    /**
     * Rocket constructor.
     * @param cost of the rocket.
     * @param weight of the rocket.
     * @param maxWeight of the rocket.
     */
    public Rocket(int cost, double weight, double maxWeight){
        this.cost = cost;
        this.weight = weight;
        this.maxWeight = maxWeight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCarry(Item item) {
        return weight + item.getWeight() <= maxWeight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void carry(Item item) {
        weight += item.getWeight();
    }

    /**
     * Gets rocket cost as int.
     * @return cost value.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets cost value.
     * @param cost value to replace.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
}