/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package antoniorojas.mission;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> items = new ArrayList<>();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        //File file = new File(filename);

        try {
            Scanner in = new Scanner(file);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                int index = line.indexOf("=");
                String name = line.substring(0, index);
                double weight = Double.parseDouble(line.substring(index + 1));
                Item item = new Item(name, weight);
                items.add(item);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File " + fileName + " not found!");
        }

        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> ui1Rockets = new ArrayList<>();
        U1 u1 = new U1();
        // fill U1 with items until full
        for (int i =0; i<items.size(); i++) {
            if (u1.canCarry(items.get(i))) {
                u1.carry(items.get(i));
            }
            else {
                ui1Rockets.add(u1);
                u1 = new U1();
            }
        }

        return ui1Rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> ui1Rockets = new ArrayList<>();
        U2 u2 = new U2();
        // fill U2 with items until full
        for (int i =0; i<items.size(); i++) {
            if (u2.canCarry(items.get(i))) {
                u2.carry(items.get(i));
            }
            else {
                ui1Rockets.add(u2);
                u2 = new U2();
            }
        }

        return ui1Rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;

        for (int i =0 ; i<rockets.size(); i++) {
            boolean launch;
            boolean land;
            do {
                totalCost = totalCost + rockets.get(i).getCost();
                launch = rockets.get(i).launch();
                land = rockets.get(i).land();
                if (!launch) {
                    System.out.println("Rocket " + rockets.get(i) + " exploded on launch! "+
                                       "Will rebuild rocket and re-launch.");
                } else {
                    System.out.print("Rocket " + rockets.get(i) + " successfully launched... ");
                    if (!land) {
                        System.out.println(" but crashed on landing! Will rebuild rocket and re-launch.");
                    } else {
                        System.out.println(" and completed the mission!");
                    }
                }
            } while (!launch || !land);
        }

        return totalCost;
    }
}
