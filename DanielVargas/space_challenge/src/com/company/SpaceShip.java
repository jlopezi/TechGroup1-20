package com.company;
/**
 * Created by Daniel Vargas on 12/05/2020.
 */
public interface SpaceShip {
    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);
}
