import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private ArrayList<Item> items;
    public Simulation(){
    }
    public void loadItems(Scanner phase) throws Exception{
        items = new ArrayList<>();
        while ((phase.hasNextLine())){
            String currentLine = phase.nextLine();
            String[] currentItem = currentLine.split("=");
            Item item = new Item(currentItem[0], Double.parseDouble(currentItem[1]));
            items.add(item);
        }
        phase.close();
    }

    public void loadU1(){
        ArrayList<Rocket> rockets = new ArrayList<>();
        int numOfRockets = 0;
        while (this.items.size() > 0){
            RocketU1 u1 = new RocketU1();
            System.out.println("=         Load Items       =");
            System.out.println("============================");
            for(int i = this.items.size() - 1; i >= 0; i--){
                if(u1.canCarry(this.items.get(i))){
                    u1.addCarry(this.items.get(i));
                    System.out.println("  " + items.get(i).getName() + " " + items.get(i).getWeight());
                    items.remove(i);
                }
            }
            rockets.add(u1);
            numOfRockets++;
            System.out.println("----------------------------");
            System.out.println("  Total Cargo: " + u1.getItemsWeight());
            System.out.println("============================\n");
        }
        System.out.println("U1 Rocket Wave Launch initiated." + "\n");
        System.out.println("Rockets launched: " + numOfRockets);
        System.out.println("");
        this.runSimulation(rockets);
    }

    public void loadU2(){
        ArrayList<Rocket> rockets = new ArrayList<>();
        int numOfRockets = 0;
        while (this.items.size() > 0){
            RocketU2 u2 = new RocketU2();
            System.out.println("U2 rocket");
            System.out.println("-----------------------------");
            for(int i = this.items.size() - 1; i >= 0; i--){
                if(u2.canCarry(this.items.get(i))){
                    u2.addCarry(this.items.get(i));
                    System.out.println("  " + items.get(i).getName() + " " + items.get(i).getWeight());
                    items.remove(i);
                }
            }
            rockets.add(u2);
            numOfRockets++;
            System.out.println("  Total Cargo: " + u2.getItemsWeight());
        }
        System.out.println("U2 Rocket Wave Launch initiated." + "\n");
        System.out.println("Rockets launched: " + numOfRockets);
        System.out.println("");
        runSimulation(rockets);
    }

    private void runSimulation(ArrayList<Rocket> rockets) {
        double totalCost = 0.0;
        int currentRocket = 0;
        int failedMissions = 0;

        for(Rocket rocket : rockets){
            totalCost = totalCost + rocket.getCost();
            currentRocket++;
            System.out.println("Current budget cost: " + totalCost);

            if(!rocket.launch()) {
                System.out.println("Rocket Launch: " + currentRocket + " Status: Failed" + "\n");
                System.out.println("Current budget: " + totalCost + "\n");
                System.out.println("Initiating new launch");
                failedMissions++;
            } else if(!rocket.land()) {
                System.out.println("Rocket Landing: " + currentRocket + " Status: Failed" + "\n");
                System.out.println("Current budget: " + totalCost + "\n");
                System.out.println("Initiating new launch" + "\n");
                failedMissions++;
            } else {
                System.out.println("Rocket: " + currentRocket + " Status: Success" + "\n");
            }
        }

        System.out.println("Total number of successful missions " + (currentRocket - failedMissions));
        System.out.println("Total number of failed missions " + failedMissions);
        System.out.println("Total Budget Cost: " + "$" + totalCost + "\n");

    }
}
