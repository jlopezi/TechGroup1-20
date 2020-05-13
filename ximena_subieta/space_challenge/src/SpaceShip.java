/**
 * This is an interface that is only declaring methods:
 */
public interface SpaceShip {

    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    int carry(Item item);

}
