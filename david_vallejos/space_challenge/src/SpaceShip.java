/**
 * Interface that rocket classes will implement.
 */
public interface SpaceShip {

    /**
     * Controls if rocket could launch successful.
     * @return true if rocket launch, otherwice false.
     */
    boolean launch();

    /**
     * Controls if rocket could land successful.
     * @return true if rocket land, otherwice false.
     */
    boolean land();

    /**
     * Controls if rocket can carry an item.
     * @param item that rocket will carry.
     * @return true if rocket can carry item, otherwise false.
     */
    boolean canCarry(Item item);

    /**
     * Adds item to rocket.
     * @param item to be carry.
     */
    void carry(Item item);
}