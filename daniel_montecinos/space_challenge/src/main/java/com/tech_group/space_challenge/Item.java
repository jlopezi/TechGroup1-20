package com.tech_group.space_challenge;

/**
 * Represents an item that can be carried into a rocket.
 */
public class Item {
    private final String name;
    private final int weight;

    /**
     * Creates and initializes an instance of Item object.
     *
     * @param name   that will be used for Item object.
     * @param weight that will be used for Item object.
     */
    public Item(final String name, final int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Gets name attribute value.
     *
     * @return name attribute as String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets weight attribute value.
     *
     * @return weight attribute as String.
     */
    public int getWeight() {
        return this.weight;
    }
}
