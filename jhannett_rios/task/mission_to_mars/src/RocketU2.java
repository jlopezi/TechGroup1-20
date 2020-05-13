import java.util.Random;

public class RocketU2 extends Rocket {
    private final static double  weight = 18000; // kg
    private final static double cost = 120000000;
    private final static double maxCargoWeight = 29000; // Kg

    public RocketU2() {
        super(weight, cost, maxCargoWeight);
    }

    @Override
    public boolean launch() {
        int random = this.getRandomNumber();
        return random > (4.0 * getItemsWeight() / (getMaxWeight() - getRocketWeight()));
    }

    @Override
    public boolean land() {
        int random = this.getRandomNumber();
        return  random > (8.0 * getItemsWeight() / (getMaxWeight() - getRocketWeight()));
    }

    private int getRandomNumber(){
        Random random = new Random();
        return  random.nextInt(100) + 1;
    }
}
