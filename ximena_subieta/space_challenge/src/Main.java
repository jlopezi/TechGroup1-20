import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Simulation sim = new Simulation();

        ArrayList<Item> phase1 = sim.loadItems("files/phase-1.txt");
        ArrayList<Item> phase2 = sim.loadItems("files/phase-2.txt");

        if (phase1.isEmpty() || phase2.isEmpty()){
            System.out.println("Empty phase1 or phase2. Please check if files are the correct ones.");
        }else {
            //U1 Rockets
            System.out.println("Phase 1 - U1");
            ArrayList<Rocket> u1FleetPhase1 = sim.loadU1(phase1);
            System.out.println("Phase 2 - U1");
            ArrayList<Rocket> u1FleetPhase2 = sim.loadU1(phase2);
            System.out.println();
            System.out.println("U1 rocket cost = 100 (millions)");
            int budgetPhase1U1 = sim.runSimulation(u1FleetPhase1);
            System.out.println("Budget for U1 fleet phase 1 = " + budgetPhase1U1 + " (millions)");
            int budgetPhase2U1 = sim.runSimulation(u1FleetPhase2);
            System.out.println("Budget for U1 fleet phase 2 = " + budgetPhase2U1 + " (millions)");

            System.out.println("Total budget for U1 fleet = " + (budgetPhase1U1 + budgetPhase2U1) + " (millions)\n");


            // U2 Rockets
            System.out.println("Phase 1 - U2");
            ArrayList<Rocket> fleetPhase1U2 = sim.loadU2(phase1);
            System.out.println("Phase 2 - U2");
            ArrayList<Rocket> fleetPhase2U2 = sim.loadU2(phase2);
            System.out.println();
            System.out.println("U2 rocket cost = 120 (millions)");
            int budgetPhase1U2 = sim.runSimulation(fleetPhase1U2);
            System.out.println("Budget for U2 fleet phase 1 = " + budgetPhase1U2 + " (millions)");
            int budgetPhase2U2 = sim.runSimulation(fleetPhase2U2);
            System.out.println("Budget for U2 fleet phase 2 = " + budgetPhase2U2 + " (millions)");

            System.out.println("Total budget for U2 fleet = " + (budgetPhase1U2 + budgetPhase2U2) + " (millions)\n");
        }
    }
}
