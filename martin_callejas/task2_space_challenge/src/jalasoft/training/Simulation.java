package jalasoft.training;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public ArrayList<Item> loadItems(String filePath) {
        ArrayList<Item> items = new ArrayList();
        File itemsFile = new File(filePath);
        try {
            Scanner fileScanner = new Scanner(itemsFile);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineSplit = line.split("=");
                items.add(new Item(lineSplit[0], Integer.parseInt(lineSplit[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return items;
    }

    public ArrayList<RocketSpaceShip> loadU1(ArrayList<Item> items) {
        ArrayList<RocketSpaceShip> u1Rockets = new ArrayList();
        int currentIndex = 0;
        U1RocketSpaceShip newRocket = new U1RocketSpaceShip();
        while (currentIndex < items.size()) {
            Item currentItem = items.get(currentIndex);
            if (newRocket.canCarry(currentItem)) {
                newRocket.carry(currentItem);
                currentIndex++;
            } else {
                u1Rockets.add(newRocket);
                newRocket = new U1RocketSpaceShip();
            }
        }
        return u1Rockets;
    }

    public ArrayList<RocketSpaceShip> loadU2(ArrayList<Item> items) {
        ArrayList<RocketSpaceShip> u2Rockets = new ArrayList();
        int currentIndex = 0;
        U2RocketSpaceShip newRocket = new U2RocketSpaceShip();
        while (currentIndex < items.size()) {
            Item currentItem = items.get(currentIndex);
            if (newRocket.canCarry(currentItem)) {
                newRocket.carry(currentItem);
                currentIndex++;
            } else {
                u2Rockets.add(newRocket);
                newRocket = new U2RocketSpaceShip();
            }
        }
        return u2Rockets;
    }

    public int runSimulation(ArrayList<RocketSpaceShip> rockets) {
        int budget = 0;
        int currentIndex = 0;
        RocketSpaceShip currentRocket;
        while (currentIndex < rockets.size()) {
            currentRocket = rockets.get(0);
            if (currentRocket.launch() && currentRocket.land())
                currentIndex++;
            budget += currentRocket.cost;
        }
        return budget;
    }
}
