/*
 * Copyright (c) 2020. Jalasoft SRL
 */

package space_mission;

/**
 * Class that represent the Object Item.
 */
public class Item {
    private String name;
    private int weight;

    /**
     * Constructor that initialize attributes
     *
     * @param name   Item name
     * @param weight Item weight
     */
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Method that return the Item Name.
     *
     * @return Item name
     */
    public String getName() {
        return name;
    }

    /**
     * Method that set the Item name.
     *
     * @param name Item Name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method that get the Item weight.
     *
     * @return the weight of the item.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Method that set the weight of the Item.
     *
     * @param weight weight of the item.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

}
