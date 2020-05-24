package com.tech_group.space_challenge;

/**
 * Interface that Rocket objects will implement.
 */
public interface SpaceShip {
    /**
     * Determines if a rocket launch was successful.
     *
     * @return true if launch was successful, false otherwise.
     */
    boolean launch();

    /**
     * Determines if a rocket land was successful.
     *
     * @return true if land was successful, false otherwise.
     */
    boolean land();

    /**
     * Determines if a rocket can carry an Item object.
     *
     * @param item that a rocket will carry.
     * @return true if rocket can carry the item, false otherwise.
     */
    boolean canCarry(final Item item);

    /**
     * Puts the item into the rocket.
     *
     * @param item that will put into the rocket.
     */
    void carry(final Item item);
}
