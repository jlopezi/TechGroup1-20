/*
 * Copyright (c) 2020. Jalasoft SRL
 */

package space_mission;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Class that simulate the process of mission to Mar
 */
public class Simulation {
    /**
     * Method that load Items.
     *
     * @param fileName File name.
     * @return ArrayList of Items.
     */
    public ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> itemList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(line -> {
                String[] itemData = line.split("=");
                itemList.add(new Item(itemData[0], Integer.parseInt(itemData[1])));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    /**
     * Method that Load  the Rocket U1 with Items.
     *
     * @param itemList Item list.
     * @return the List of created Rockets.
     */
    ArrayList<Rocket> loadU1(ArrayList<Item> itemList) {
        ArrayList<Rocket> rocketU1List = new ArrayList<>();
        Rocket rocketU1 = new U1();
        for (Item item : itemList) {
            if (rocketU1.canCarry(item)) {
                rocketU1.carry(item);
            } else {
                rocketU1List.add(rocketU1);
                rocketU1 = new U1();
            }
        }
        return rocketU1List;
    }

    /**
     * Method that load Items to the Rocket U2.
     *
     * @param itemList item list.
     * @return list of created Rockets.
     */
    ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {
        ArrayList<Rocket> rocketU2List = new ArrayList<>();
        Rocket rocketU2 = new U2();
        for (Item item : itemList) {
            if (rocketU2.canCarry(item)) {
                rocketU2.carry(item);
            } else {
                rocketU2List.add(rocketU2);
                rocketU2 = new U2();
            }
        }
        return rocketU2List;
    }

    /**
     * Method that run the simulation given the rocket list
     *
     * @param rocketList rocket list
     * @return the total budget
     */
    public int runSimulation(ArrayList<Rocket> rocketList) {
        int budget = 0;
        for (Rocket rocket : rocketList) {
            while (!rocket.land() || !rocket.launch()) {
                System.out.println("Rocket launch/land has been failed");
                budget = budget + rocket.cost;
            }
            budget = budget + rocket.cost;
        }
        return budget;
    }
}
