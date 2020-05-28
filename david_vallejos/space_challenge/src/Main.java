import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to start simulations.
 */
public class Main {

    public static void main(String[] args) {

        String phase1Path="src/Phase-1.txt";
        String phase2Path="src/Phase-2.txt";

        final NumberFormat format = NumberFormat.getCurrencyInstance();
        Simulation firstSimulation = new Simulation();


        List<Item> itemsPhase1 = firstSimulation.loadItems(phase1Path);

        List<Rocket> u1Phase1Rockets = firstSimulation.loadU1(itemsPhase1);
        int u1Phase1TocalCost = firstSimulation.runSimulator(u1Phase1Rockets);
        System.out.println(String.format("Phase 1 for U1 rockets will cost: %s",format.format(u1Phase1TocalCost)));

        List<Rocket> u2Phase1Rockets = firstSimulation.loadU2(itemsPhase1);
        int u2Phase1TocalCost = firstSimulation.runSimulator(u2Phase1Rockets);
        System.out.println(String.format("Phase 1 for U2 rockets will cost: %s",format.format(u2Phase1TocalCost)));


        List<Item> itemsPhase2 = firstSimulation.loadItems(phase2Path);

        List<Rocket> u1Phase2Rockets = firstSimulation.loadU1(itemsPhase2);
        int u1Phase2TocalCost = firstSimulation.runSimulator(u1Phase1Rockets);
        System.out.println(String.format("Phase 2 for U1 rockets will cost: %s",format.format(u1Phase2TocalCost)));

        List<Rocket> u2Phase2Rockets = firstSimulation.loadU2(itemsPhase2);
        int u2Phase2TocalCost = firstSimulation.runSimulator(u2Phase2Rockets);
        System.out.println(String.format("Phase 2 for U2 rockets will cost: %s",format.format(u2Phase2TocalCost)));
    }
}