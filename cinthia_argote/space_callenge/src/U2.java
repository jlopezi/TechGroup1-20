public class U2 extends Rocket {
  private final static int cost = 120; // 120 millions
  private final static double rocketWeight = 18000; // 18 tones
  private final static double maxWeight = 29000; // 29 tones
   
  public U2() {
    super(rocketWeight, maxWeight, cost);
  }

  @Override
  public boolean launch() {
    double random = Math.random();
    return random > (0.04 * (getWeight() / getMaxWeight()));
  }

  @Override
  public boolean land() {
    double random = Math.random();
    return random > (0.08 * (getWeight() / getMaxWeight()));
  }
}