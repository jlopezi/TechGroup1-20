/*
 * Copyright (c) 2020. Jalasoft SRL
 */

package space_mission;

/**
 * Interface Space Ship.
 */
public interface SpaceShip {
    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);
}
