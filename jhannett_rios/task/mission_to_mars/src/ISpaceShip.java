public interface ISpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void addCarry(Item item);
}
