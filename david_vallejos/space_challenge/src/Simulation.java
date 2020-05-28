import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that contain Simulation methods.
 */
public class Simulation {

    /**
     * Loads items from txt file.
     * @param fileName path followed with file name.
     * @return a List of items from txt file.
     */
    public List<Item> loadItems(String fileName) {
        List<Item> items = new ArrayList<>();

        try {
            List<String> fileList = Files.readAllLines(new File(fileName).toPath(), Charset.defaultCharset());
            for (String item : fileList) {
                items.add(new Item(item.split("=")[0], Integer.parseInt(item.split("=")[1])));
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Loads U1 rocket with items that can carry.
     * @param items that can be carry by rocket.
     * @return a list of Rocket invested.
     */
    public List<Rocket> loadU1(List<Item> items) {
        U1 rocket = new U1();
        return getRocketList(rocket, items);
    }

    /**
     * Gets rockets list that was filled.
     * @param rocket object.
     * @param items list that have been carry.
     * @return a List of rocket filled out.
     */
    private List<Rocket> getRocketList(Rocket rocket, List<Item> items) {
        List<Rocket> rocketList = new ArrayList<>();
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketList.add(rocket);
                rocket = createRocket(rocket);
                rocket.carry(item);
            }
        }
        return rocketList;
    }

    /**
     * Creates rocket U1 or U2 object.
     * @param rocket represent the class of rocket.
     * @return rocket depends of class sent.
     */
    private static Rocket createRocket(Rocket rocket) {
        return rocket.getClass() == U1.class ? new U1() : new U2();
    }

    /**
     * Loads U2 rocket with items that can carry.
     * @param items that can be carry by rocket.
     * @return a list of Rocket invested.
     */
    public List<Rocket> loadU2(List<Item> items) {
        U2 rocket = new U2();
        return getRocketList(rocket, items);
    }

    /**
     * Runs simulation for Rockets.
     * @param rockets list that contains all rockets.
     * @return total of cost of the simulation
     */
    public int runSimulator(List<Rocket> rockets) {
        int cost = 0;
        for (Rocket rocket : rockets) {
            while (rocket.launch() || rocket.land()) {
                cost += rocket.getCost();
            }
        }
        return cost;
    }
}