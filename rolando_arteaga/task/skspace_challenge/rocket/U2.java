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
public class U2 extends Rocket {

    public U2() {
      super("U-2", 18, 29, 120);
    }

    @Override
    public boolean launch() {
        double chance = 0.04 * (super.getWeight() / this.getMaxWeight());
        return  chance > 0; 
    }

    @Override
    public boolean land() {
        double chance = 0.08 * (super.getWeight() / this.getMaxWeight());
        return  chance > 0;
    }
    
}
