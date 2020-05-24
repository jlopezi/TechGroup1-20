package com.tech_group.space_challenge;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class that contains only methods to run a simulation of U1 and U2 rockets.
 */
public final class Simulation {

    /**
     * Private constructor.
     */
    private Simulation() {
    }

    /**
     * Loads items from a .txt file located in the project.
     *
     * @param phasePath represents the directory path where the file is located.
     * @return a List of Items obtained from phase file.
     */
    public static List<Item> loadItems(final String phasePath) {
        File phase = new File(phasePath);
        List<Item> items = new ArrayList<>();
        try {
            List<String> listOfElements = Files.readAllLines(phase.toPath(), Charset.defaultCharset());
            for (String element : listOfElements) {
                Item item = new Item(element.split("=")[0], Integer.parseInt(element.split("=")[1]));
                items.add(item);
            }

        } catch (IOException e) {
            System.out.println("File cannot be read.");
            System.out.println("An empty list will be returned instead.");
        }
        return items;
    }

    /**
     * Loads a List of U1 rockets.
     *
     * @param items that will be put into UI rockets.
     * @return a List of U1 rockets that represents how many of them will be necessary to transport all items.
     */
    public static List<Rocket> loadU1(final List<Item> items) {
        String rocketType = "U1";
        return generateRocketList(rocketType, items);
    }

    /**
     * Loads a List of U2 rockets.
     *
     * @param items that will be put into UI rockets.
     * @return a List of U2 rockets that represents how many of them will be necessary to transport all items.
     */
    public static List<Rocket> loadU2(final List<Item> items) {
        String rocketType = "U2";
        return generateRocketList(rocketType, items);
    }

    /**
     * Runs simulation for U1 or U2 rockets.
     *
     * @param rockets represents the list that contains all Rocket objects.
     * @return the total cost of send U1 or U2 rockets to Mars.
     */
    public static Double runSimulation(final List<Rocket> rockets) {
        Double totalCost = 0.0;
        int tries = 0;
        for (Rocket rocket : rockets) {
            Scanner scanner = new Scanner(System.in);
            while (rocket.launch() || rocket.land()) {
                System.out.println("Rocket exploded!!. We'll build and we'll send a new one");
                totalCost += rocket.getCost();
                tries++;
            }
            System.out.println("------------------------------------------------------------------------");
            System.out.println(String.format("After %s tries, rocket arrived at its destiny. Hooray!!", tries));
            System.out.println("Press Enter to continue......");
            System.out.println("------------------------------------------------------------------------");
            scanner.nextLine();
            tries = 0;
        }
        return totalCost;
    }

    /**
     * Generates a list of U1 or U2 Rockets objects.
     *
     * @param rocketType represents the type of Rocket intended to create.
     * @param items      that will be put in Rocket object.
     * @return a list of U1 or U2 Rockets objects.
     */
    private static List<Rocket> generateRocketList(final String rocketType, final List<Item> items) {
        List<Rocket> rockets = new ArrayList<>();
        Rocket rocket = createRocket(rocketType);
        for (Item item : items) {
            if (!rocket.canCarry(item)) {
                rockets.add(rocket);
                rocket = createRocket(rocketType);
            }
            rocket.carry(item);
        }
        return rockets;
    }

    /**
     * Creates both a U1 or a U2 Rocket object.
     *
     * @param rocketType represent the type or object we want to create.
     * @return a U1 or a U2 Rocket object.
     */
    private static Rocket createRocket(final String rocketType) {
        return rocketType.equalsIgnoreCase("U1") ? new U1() : new U2();
    }
}
