package main.java;

/**
 * ApoloU1 class.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ApoloU1 extends Rocket {

    public ApoloU1() {
        super(100, 18,10);
    }

    /**
     * Lands method calculate corresponding chance of exploding.
     * @return true if we going well on the land, otherwise false.
     */
    @Override
    public boolean land() {
        return isExplosion(0.01, Math.random());
    }

    /**
     * Launches method calculate corresponding chance of exploding.
     * @return true if we going well on the launch, otherwise false.
     */
    @Override
    public boolean launch() {
        return isExplosion(0.05, Math.random());
    }
}
