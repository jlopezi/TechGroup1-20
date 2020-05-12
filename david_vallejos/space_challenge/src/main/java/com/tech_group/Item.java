package main.java.com.tech_group;

/**
 * Class that represent item to carry into a rocket.
 */
public class Item {

    private String name;
    private int weight;

    /**
     * Item constructor.
     * @param name of the Item.
     * @param weight of the Item.
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}