import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation marsSimulation = new Simulation();
        ArrayList<Item> phaseOnePayload = new ArrayList<>();
        ArrayList<Item> phaseTwoPayload = new ArrayList<>();
        int u1Budget = 0;
        int u2Budget = 0;

        try {
            phaseOnePayload = marsSimulation.loadItems("src/main/resources/phase-1.txt");
        } catch (FileNotFoundException fnf) {
            System.out.println("Phase-1 Payload file not found!");
        }

        try {
            phaseTwoPayload = marsSimulation.loadItems("src/main/resources/phase-2.txt");
        } catch (FileNotFoundException fnf) {
            System.out.println("Phase-2 Payload file not found!");
        }

        ArrayList<Rocket> u1RocketsPhaseOne = marsSimulation.loadU1(phaseOnePayload);
        ArrayList<Rocket> u1RocketsPhaseTwo = marsSimulation.loadU1(phaseTwoPayload);

        u1Budget += marsSimulation.runSimulation(u1RocketsPhaseOne);
        u1Budget += marsSimulation.runSimulation(u1RocketsPhaseTwo);

        ArrayList<Rocket> u2RocketsPhaseOne = marsSimulation.loadU2(phaseOnePayload);
        ArrayList<Rocket> u2RocketsPhaseTwo = marsSimulation.loadU2(phaseTwoPayload);

        u2Budget += marsSimulation.runSimulation(u2RocketsPhaseOne);
        u2Budget += marsSimulation.runSimulation(u2RocketsPhaseTwo);
        System.out.println("Budget required for sending U1 Rockets: $" + u1Budget + " million.");
        System.out.println("Budget required for sending U2 Rockets: $" + u2Budget + " million.");

        if (u1Budget < u2Budget) {
            System.out.println("\nIt is cheaper to use U1 Rockets.");
        } else if (u2Budget < u1Budget) {
            System.out.println("\nIt is cheaper to use U2 Rockets.");
        } else {
            System.out.println("Both cost the same. It is OK to use either.");
        }
    }
}
