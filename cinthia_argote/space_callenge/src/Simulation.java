import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
  public ArrayList<Item> loadItems(String filePath) {
    ArrayList<Item> phase = new ArrayList<>();
    try {
        File myFile = new File(filePath);
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split("=");
            phase.add(new Item(data[0], Integer.parseInt(data[1])));
        }
        myReader.close();
        return phase;
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred with the file.");
        e.printStackTrace();
        return phase;
    }
  }

  private  ArrayList<Rocket> loadU(ArrayList<Item> items, Rocket rocket) {
    ArrayList<Rocket> URockets = new ArrayList<>();
    for (int i =0; i<items.size(); i++) {
        if (rocket.canCarry(items.get(i))) {
          rocket.carry(items.get(i));
        }
        else {
          URockets.add(rocket);
          rocket  = new U1();
        }
    }

    return URockets;
  }

  public ArrayList<Rocket> loadU1(ArrayList<Item> items){
    U1 rocket  = new U1();
    return loadU(items, rocket);
  }

  public ArrayList<Rocket> loadU2(ArrayList<Item> items){
    U2 rocket  = new U2();
    return loadU(items, rocket);
  }

  public int runSimulation(ArrayList<Rocket> rockets) {
    int cost = 0;
    while(rockets.size() > 0) {
      Rocket currentRocket = rockets.remove(0);
      cost+=currentRocket.getCost();
      if (!currentRocket.launch() || !currentRocket.land()) {
          rockets.add(currentRocket);
      }
    }
    return cost;
  }
}