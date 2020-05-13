import java.util.ArrayList;

public class Rocket implements ISpaceShip {
    private double weight;
    private double maxCargoWeight;
    private double cost;
    private ArrayList<Item> items;

    public Rocket(double weight, double cost, double maxCargoWeight){
        this.weight = weight;
        this.cost = cost;
        this.maxCargoWeight = maxCargoWeight;
        this.items = new ArrayList<Item>();
    }

    public double getRocketWeight(){
        return this.weight;
    }

    public double getMaxCargoWeight(){
        return this.maxCargoWeight;
    }

    public double getMaxWeight(){
        return  this.weight + this.maxCargoWeight;
    }

    public double getCost(){
        return this.cost;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        return (this.getItemsWeight() + item.getWeight()) <= this.getMaxWeight();
    }

    @Override
    public void addCarry(Item item) {
        this.items.add(item);
    }

    public double getItemsWeight(){
        double itemsWeight = 0;
        for(Item item : this.items){
            itemsWeight = itemsWeight + item.getWeight();
        }

        return itemsWeight;
    }
}
