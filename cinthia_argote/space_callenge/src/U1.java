public class U1 extends Rocket {
  private final static int cost = 100; // 100 millions
  private final static double rocketWeight = 10000; // 10 tones
  private final static double maxWeight = 18000; // 18 tones
   
  public U1() {
    super(rocketWeight, maxWeight, cost);
  }

  @Override
  public boolean launch() {
    double random = Math.random();
    return random > (0.05 * (getWeight() / getMaxWeight()));
  }

  @Override
  public boolean land() {
    double random = Math.random();
    return random > (0.01 * (getWeight() / getMaxWeight()));
  }
}