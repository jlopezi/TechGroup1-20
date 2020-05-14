package rocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author roly
 */
public interface ISpaceShip {
    /**
     * indicating if the launch was successful or if the rocket has
     * crashed.
     * @return either true or false
     */
    public boolean launch();
    
    /**
     * land: a method that also returns either true or false based on 
     * the success of the landing.
     * @return either true or false
     */
    public boolean land();
    
    /**
     *  a method that takes an Item as an argument and returns true if 
     * the rocket can carry such item or false
     * @param item
     * @return either true or false
    */
    public boolean canCarry(Item item);
    
    /**
     * carry: a method that also takes an Item objec
     * and updates the current weight of the rocket.
     * @param item
     * @return either true or false
     */
    public boolean carry(Item item);
}
