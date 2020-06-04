
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;



public class Simulation {
    // Responsible for reading item data and filling up the rockets
    public ArrayList<Item> itemList = new ArrayList<Item>();
    public ArrayList<Rocket> u1RocketList = new ArrayList<Rocket>();
    public ArrayList<Rocket> u2RocketList = new ArrayList<Rocket>();
    public int budget;

    public ArrayList<Item> loadItems(String phase) throws FileNotFoundException {

        //reads a text file line by line and create an item object for each
        //and add it to an arrayList of Items.
        Item item = new Item();

        Scanner s = new Scanner(new File("src/" + phase));

        while (s.hasNextLine()){
            String line = s.nextLine();
            String[] splitLine = line.split("=");
            item.setName(splitLine[0]);
            item.setweight(Integer.parseInt(splitLine[1]));
            itemList.add(item);
            item = new Item();
        }
        s.close();

        return itemList;
    }

    public ArrayList<Rocket> loadU1(){

        //creates U1 rockets
        //first tries to fill up the rocket 1 with as many items as possible.
        // before creating another rocket object until all items are loaded.
        //return the arrayList of those U1 rockets fully loaded
        Rocket rocket = new U1();
        for (Item item : itemList) {
            if(rocket.canCarry(item)){
                rocket.carry(item);
            } else {
                u1RocketList.add(rocket);
                rocket = new U1();
                rocket.carry(item);
            }
        }

        return u1RocketList;
    }


    public ArrayList<Rocket> loadU2(){

        //creates U2 rockets
        //first tries to fill up the rocket 1 with as many items as possible.
        // before creating another rocket object until all items are loaded.
        //return the arrayList of those U1 rockets fully loaded
        Rocket rocket = new U2();
        for (Item item : itemList) {
            if(rocket.canCarry(item)){
                rocket.carry(item);
            } else {
                u2RocketList.add(rocket);
                rocket = new U2();
            }
        }

        return u2RocketList;
    }

    public int runSimulation(ArrayList<Rocket> rocketList) {
        budget = 0;
        for (Rocket rocket : rocketList) {
            budget = tryRocket(budget, rocket);
        }
        return budget;
    }

    public int tryRocket(int budget, Rocket rocket) {
        budget = budget + rocket.cost;
//        System.out.println("se prueba el cohete el presupuesto ahora es:" + Integer.toString(budget));
        if(!rocket.launch() || !rocket.land()){
//            System.out.println("fallo, se manda de nuevo el cohete :" + Integer.toString(budget));
            budget = budget + rocket.cost;
            tryRocket(budget,rocket);

        }
        return budget;
    }
}
