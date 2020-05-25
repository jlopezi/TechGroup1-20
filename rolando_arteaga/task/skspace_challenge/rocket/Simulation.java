/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocket;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author roly
 */
public class Simulation {

    public Simulation() {
    }

    public static ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> phase1 = new ArrayList<>();
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split("=");
                phase1.add(new Item(data[0], Integer.parseInt(data[1])));
            }
            myReader.close();
            return phase1;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return phase1;
        }
    }

   public static ArrayList<Rocket> loadU(Rocket rocket, ArrayList<Item> items) {
        ArrayList<Rocket> rocketList = new ArrayList<>();
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketList.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
        }
        return rocketList;
    }

    public static ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        return Simulation.loadU(new U1(), items);
    }

    public static ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        return Simulation.loadU(new U1(), items);
    }
    
    public static int runSimulation(ArrayList<Rocket> rockets) {
        int cost = 0;
        while(rockets.size() > 0) {
          Rocket currentRocket = rockets.remove(0);
          cost+=currentRocket.getCosts();
          if (!currentRocket.launch() || !currentRocket.land()) {
              rockets.add(currentRocket);
          }
        }
        return cost;
  }
}
