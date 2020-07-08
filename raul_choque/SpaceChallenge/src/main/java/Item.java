package main.java;

/**
 * main.java.Item class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Item {
    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
