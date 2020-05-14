public class Rocket implements SpaceShip {
  private double weight;
  private double maxWeight;
  private int cost;

  public Rocket(double weight, double maxWeight, int cost) {
    this.weight = weight;
    this.maxWeight = maxWeight;
    this.cost = cost;
  }

  public double getMaxWeight() {
    return maxWeight;
  }

  public void setMaxWeight(double maxWeight) {
    this.maxWeight = maxWeight;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  
  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  @Override
  public boolean canCarry(Item item) {
    return weight + item.getWeight() <= maxWeight;
  }

  @Override
  public void carry(Item item) {
    weight+= item.getWeight();
  }

  @Override
  public boolean launch() {
    return true;
  }

  @Override
  public boolean land() {
    return true;
  }
  
}