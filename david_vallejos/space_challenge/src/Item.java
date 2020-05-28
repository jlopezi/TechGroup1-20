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

    /**
     * Gets item name.
     * @return name as String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets item name.
     * @param name replace name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets item weight.
     * @return weight as int.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets item weight.
     * @param weight to replace current value.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}