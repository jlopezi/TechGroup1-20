package main.java.com.tech_group;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class that contain Simulation methods.
 */
public class Simulation {

    /**
     * Loads items from txt file.
     * @param fileName path followed with file name.
     * @return a List of items from txt file.
     */
    public ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> items = new ArrayList<>();

        try {
            ArrayList<String> fileList = (ArrayList<String>) Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
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
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        U1 rocket = new U1();
        return getRocketList(rocket, items);
    }

    /**
     * Gets rockets list that was filled.
     * @param rocket object.
     * @param items list that have been carry.
     * @return a List of rocket filled out.
     */
    private ArrayList<Rocket> getRocketList(Rocket rocket, ArrayList<Item> items) {
        ArrayList<Rocket> rocketList = new ArrayList<>();
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketList.add(rocket);
                if (rocket.getClass() == U1.class) {
                    rocket = new U1();
                } else {
                    rocket = new U2();
                }
//                rocket = rocket.getClass() == U1.class ? new U1() : new U2;
                rocket.carry(item);
            }
        }
        return rocketList;
    }

    /**
     * Loads U2 rocket with items that can carry.
     * @param items that can be carry by rocket.
     * @return a list of Rocket invested.
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        U2 rocket = new U2();
        return getRocketList(rocket, items);
    }

    /**
     * Runs simulation for Rockets.
     * @param rockets list that contains all rockets.
     * @return total of cost of the simulation
     */
    public int runSimulator(ArrayList<Rocket> rockets) {
        int cost = 0;
        for (Rocket rocket : rockets) {
            while (rocket.launch() || rocket.land()) {
                cost += rocket.getCost();
            }
        }
        return cost;
    }
}