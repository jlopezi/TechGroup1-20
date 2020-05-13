/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocket;

import java.util.ArrayList;

/**
 *
 * @author roly
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Item> phase1 = Simulation.loadItems("./phase-1.txt");
        ArrayList<Item> phase2 = Simulation.loadItems("./phase-2.txt");

        ArrayList<Rocket> rockets1U1 = Simulation.loadU1(phase1);
        ArrayList<Rocket> rockets1U2 = Simulation.loadU2(phase1);

        ArrayList<Rocket> rockets2U1 = Simulation.loadU1(phase2);
        ArrayList<Rocket> rockets2U2 = Simulation.loadU2(phase2);

        int costPhase1U1 = Simulation.runSimulation(rockets1U1);
        int costPhase1U2 = Simulation.runSimulation(rockets1U2);
        System.out.println("Phase 1 for U1 rockets will cost: " + costPhase1U1);
        System.out.println("Phase 1 for U2 rockets will cost: " + costPhase1U2);

        int costPhase2U1 = Simulation.runSimulation(rockets2U1);
        int costPhase2U2 = Simulation.runSimulation(rockets2U2);
        System.out.println("Phase 2 for U1 rockets will cost: " + costPhase2U1);
        System.out.println("Phase 2 for U2 rockets will cost: " + costPhase2U2);
    }
    
}
