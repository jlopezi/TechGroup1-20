package main.java;

/**
 * main.java.SpaceShip interface.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public interface SpaceShip {

    public boolean launch();
    public boolean land();
    public boolean canCarry(Item item);
    public void carry(Item item);
}
