/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocket;

/**
 *
 * @author roly
 */


public class Rocket implements ISpaceShip{
    private String name;
    private int weight, maxWeight;
    private int costs;
    private int KILOS_BY_TONE = 1000;

    public Rocket(String name, int weight, int maxWeight, int costs) {
        this.name = name;
        this.weight = weight * KILOS_BY_TONE;
        this.maxWeight = maxWeight * KILOS_BY_TONE;
        this.costs = costs;
    }
    
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCosts() {
        return costs;
    }

    public int getMaxWeight() {
        return maxWeight;
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
        return this.weight + item.getCost() <= this.maxWeight;
    }

    @Override
    public boolean carry(Item item) {
       this.weight += item.getCost();
       return this.weight <= this.maxWeight;
    }

    @Override
    public String toString() {
        return "Rocket{" + "name=" + name + ", weight=" + weight + ","
                + " maxWeight=" + maxWeight + ", costs=" + costs + ", "
                + "KILOS_BY_TONE=" + KILOS_BY_TONE + '}';
    }
    
    public void print(){
        System.out.println(this.toString());
    }
}
