/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocket;

/**
 *
 * @author roly
 */
public class U1 extends Rocket {

    public U1() {
        super("U-1", 10, 18, 100);
    }

    @Override
    public boolean launch() {
        double chance = 0.05 * (super.getWeight() / this.getMaxWeight());
        return  chance > Math.random(); 
    }

    @Override
    public boolean land() {
        double chance = 0.01 * (super.getWeight() / this.getMaxWeight());
        return  chance > 0;
    }
    
}
