package com.tech_group.space_challenge;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

/**
 * Class used to start rockets simulation.
 */
public class Main {
    public static void main(String[] args) {
        final String phaseOnePath =
                "daniel_montecinos/space_challenge/src/main/java/com/tech_group/resources/phase-1.txt";
        final String phaseTwoPath =
                "daniel_montecinos/space_challenge/src/main/java/com/tech_group/resources/phase-2.txt";
        final NumberFormat format = NumberFormat.getCurrencyInstance();
        List<Item> items;
        List<Rocket> rockets;
        Double cost;

        System.out.println("Starting U1 Rockets Phase 1 Simulation!!");
        printContinueMessage();
        items = Simulation.loadItems(phaseOnePath);
        rockets = Simulation.loadU1(items);
        cost = Simulation.runSimulation(rockets);
        System.out.println(String.format("Phase 1 for U1 rockets will cost: %s",format.format(cost)));
        printContinueMessage();

        System.out.println("Starting U1 Rockets Phase 2 Simulation!!");
        printContinueMessage();
        items = Simulation.loadItems(phaseOnePath);
        rockets = Simulation.loadU2(items);
        cost = Simulation.runSimulation(rockets);
        System.out.println(String.format("Phase 2 for U1 rockets will cost: %s",format.format(cost)));
        printContinueMessage();

        System.out.println("Starting U2 Rockets Phase 1 Simulation!!");
        printContinueMessage();
        items = Simulation.loadItems(phaseTwoPath);
        rockets = Simulation.loadU2(items);
        cost = Simulation.runSimulation(rockets);
        System.out.println(String.format("Phase 1 for U2 rockets will cost: %s",format.format(cost)));
        printContinueMessage();

        System.out.println("Starting U2 Rockets Phase 2 Simulation!!");
        printContinueMessage();
        items = Simulation.loadItems(phaseTwoPath);
        rockets = Simulation.loadU2(items);
        cost = Simulation.runSimulation(rockets);
        System.out.println(String.format("Phase 2 for U2 rockets will cost: %s",format.format(cost)));
        printContinueMessage();
    }

    /**
     * Prints a message and waits the user hits the Enter key.
     */
    private static void printContinueMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to continue......");
        scanner.nextLine();
    }
}
