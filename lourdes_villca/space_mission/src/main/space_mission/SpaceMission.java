package space_mission;

import java.util.ArrayList;

public class SpaceMission {

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        String phase1 = "src/main/space_mission/Phase-1.txt";
        String phase2 = "src/main/space_mission/Phase-2.txt";
        System.out.println("Running Simulation U1");
        ArrayList<Rocket> rocketU1ListPhase1 = simulation.loadU1(simulation.loadItems(phase1));
        ArrayList<Rocket> rocketU1ListPhase2 = simulation.loadU1(simulation.loadItems(phase2));
        int budgetU1Phase1 = simulation.runSimulation(rocketU1ListPhase1);
        int budgetU1Phase2 = simulation.runSimulation(rocketU1ListPhase2);
        System.out.printf("Total Budget for U1 Phase1 + Phase2: %d Millions", budgetU1Phase1 + budgetU1Phase2);

        System.out.println("\nRunning Simulation U2");
        ArrayList<Rocket> rocketU2ListPhase1 = simulation.loadU1(simulation.loadItems(phase1));
        ArrayList<Rocket> rocketU2ListPhase2 = simulation.loadU1(simulation.loadItems(phase2));
        int budgetU2Phase1 = simulation.runSimulation(rocketU2ListPhase1);
        int budgetU2Phase2 = simulation.runSimulation(rocketU2ListPhase2);
        System.out.printf("Total Budget for U1 Phase1 + Phase2: %d Millions", budgetU2Phase2 + budgetU2Phase2);
    }
}
