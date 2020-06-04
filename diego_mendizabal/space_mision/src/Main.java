import java.io.FileNotFoundException;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {

        Simulation simulation = new Simulation();
        simulation.loadItems("Phase1.txt");
        simulation.loadU1();
        simulation.loadU2();
        int budget1 = simulation.runSimulation(simulation.u1RocketList);
        int budget2 = simulation.runSimulation(simulation.u2RocketList);
        System.out.println("the budget for the U1 in phase 1 is:" + Integer.toString(budget1));
        System.out.println("the budget for the U2 in phase 1 is:" + Integer.toString(budget2));

        Simulation simulation2 = new Simulation();
        simulation2.loadItems("Phase2.txt");
        simulation2.loadU1();
        simulation2.loadU2();
        int budget3 = simulation2.runSimulation(simulation2.u1RocketList);
        int budget4 = simulation2.runSimulation(simulation2.u2RocketList);
        System.out.println("the budget for the U1 in phase 2 is:" + Integer.toString(budget3));
        System.out.println("the budget for the U2 in phase 2 is:" + Integer.toString(budget4));

    }
}
