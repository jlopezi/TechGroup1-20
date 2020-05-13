import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is Simulation class
 */
public class Simulation {

    public Simulation() { }


    public ArrayList<Item> loadItems(String fileName){
        ArrayList<Item> items = new ArrayList<>();
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] oneItem = line.split("=");
                items.add(new Item(oneItem[0], Integer.valueOf(oneItem[1])));
            }
        } catch(Exception exception){
            System.out.println("Error occurred: " + exception.toString());
        } finally {
            return items;
        }
    }


    public ArrayList<Rocket> loadU1(ArrayList<Item> list) {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket rocketU1 = new U1();

        int itemCounter = 1;
        int rocketCounter = 1;

        System.out.println("U1 Rocket weight = " + rocketU1.weight + "; maxWeight = " + rocketU1.maxWeight);

        for (Item i : list) {

            while (!rocketU1.canCarry(i)) {
                rocketCounter++;
                fleet.add(rocketU1);
                rocketU1 = new U1();
            }
            rocketU1.carry(i);
            itemCounter++;
        }
        fleet.add(rocketU1);
        System.out.println("U1 fleet contains " + fleet.size() + " rockets");
        return fleet;
    }


    public ArrayList<Rocket> loadU2(ArrayList<Item> list) {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket rocketU2 = new U2();

        int itemCounter = 1;
        int rocketCounter = 1;

        System.out.println("U2 Rocket weight = " + rocketU2.weight + "; maxWeight = " + rocketU2.maxWeight);
        for (Item i : list) {

            while (!rocketU2.canCarry(i)) {
                rocketCounter++;
                fleet.add(rocketU2);
                rocketU2 = new U2();
            }
            rocketU2.carry(i);
            itemCounter++;
        }
        fleet.add(rocketU2);
        System.out.println("U2 fleet contains " + fleet.size() + " rockets");
        return fleet;
    }


    public int runSimulation(ArrayList<Rocket> rocket) {
        int num = 0;
        int indexSuccess = 1;

        for (Rocket mission : rocket) {
            while (!mission.launch()) {
                mission.launch();
                num++;
            }

            while (!mission.land()) {
                mission.land();
                num++;
            }
            indexSuccess++;
        }

        int budget = rocket.get(0).cost * (rocket.size() + num);
        System.out.println(rocket.size() + " rockets and " + num + " extras = "
                + (rocket.size() + num) + " in total");
        return budget;
    }

}
