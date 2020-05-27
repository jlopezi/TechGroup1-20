public interface SpaceShip {
    static boolean launch() {
     // if the launch was successful true
     return true;
    }

    static boolean land() {
        // if the launch was successful true
        return true;
    }

    static boolean canCarry(Item item) {
        // if can carry an Item
        return true;
    }

    static void carry(Item item) {
        // Modifies the weight of the rocket
    }

}
