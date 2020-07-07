import java.util.Random;

public class RocketU1 extends Rocket {
    private final static double  weight = 10000; // kg
    private final static double cost = 100000000;
    private final static double maxCargoWeight = 18000; // Kg

    public RocketU1() {
        super(weight, cost, maxCargoWeight);
    }

    @Override
    public boolean launch() {
        int random = this.getRandomNumber();
        return random > (5.0 * getItemsWeight() / (getMaxWeight() - getRocketWeight()));
    }

    @Override
    public boolean land() {
        int random = this.getRandomNumber();
        return random > (1.0 * getItemsWeight() / (getMaxWeight() - getRocketWeight()));
    }

    private int getRandomNumber(){
        Random random = new Random();
        return  random.nextInt(100) + 1;
    }
}
