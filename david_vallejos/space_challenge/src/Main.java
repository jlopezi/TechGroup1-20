import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Class to start simulations.
 */
public class Main {

    public static void main(String[] args) {

        String phase1Path="Phase-1.txt";
        String phase2Path="Phase-2.txt";

        System.out.println(Paths.get(phase1Path).toAbsolutePath().toString());
        System.out.println(Paths.get(phase2Path).toAbsolutePath().toString());

        final String filePathPhase1 = Paths.get(phase1Path).toAbsolutePath().toString();
        final String filePathPhase2 = Paths.get(phase2Path).toAbsolutePath().toString();
        final NumberFormat format = NumberFormat.getCurrencyInstance();
        Simulation firstSimulation = new Simulation();


        ArrayList<Item> itemsPhase1 = firstSimulation.loadItems(filePathPhase1);

        ArrayList<Rocket> u1Phase1Rockets = firstSimulation.loadU1(itemsPhase1);
        int u1Phase1TocalCost = firstSimulation.runSimulator(u1Phase1Rockets);
        System.out.println(String.format("Phase 1 for U1 rockets will cost: %s",format.format(u1Phase1TocalCost)));

        ArrayList<Rocket> u2Phase1Rockets = firstSimulation.loadU2(itemsPhase1);
        int u2Phase1TocalCost = firstSimulation.runSimulator(u2Phase1Rockets);
        System.out.println(String.format("Phase 1 for U2 rockets will cost: %s",format.format(u2Phase1TocalCost)));


        ArrayList<Item> itemsPhase2 = firstSimulation.loadItems(filePathPhase2);

        ArrayList<Rocket> u1Phase2Rockets = firstSimulation.loadU1(itemsPhase2);
        int u1Phase2TocalCost = firstSimulation.runSimulator(u1Phase1Rockets);
        System.out.println(String.format("Phase 2 for U1 rockets will cost: %s",format.format(u1Phase2TocalCost)));

        ArrayList<Rocket> u2Phase2Rockets = firstSimulation.loadU2(itemsPhase2);
        int u2Phase2TocalCost = firstSimulation.runSimulator(u2Phase2Rockets);
        System.out.println(String.format("Phase 2 for U2 rockets will cost: %s",format.format(u2Phase2TocalCost)));
    }
}