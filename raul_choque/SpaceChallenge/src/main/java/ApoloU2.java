package main.java;

/**
 * ApoloU2 class.
 *
 * @author Raúl Choque
 * @version 0.0.1
 */
public class ApoloU2 extends Rocket {

    public ApoloU2() {
        super(120,29,18);
    }

    /**
     * Lands method calculate corresponding chance of exploding.
     * @return false if we going well on the land, otherwise true.
     */
    @Override
    public boolean land() {
        return isExplosion(0.08, Math.random());
    }

    /**
     * Launches method calculate corresponding chance of exploding.
     * @return false if we going well on the launch, otherwise true.
     */
    @Override
    public boolean launch() {
        return isExplosion(0.04, Math.random());
    }
}
