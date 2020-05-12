package main.java.com.tech_group;

public interface SpaceShip {
    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);
}