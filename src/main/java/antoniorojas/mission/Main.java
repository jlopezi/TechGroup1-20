/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package antoniorojas.mission;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
    public static void main(String[] args){
        Locale locale = new Locale("en", "US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        Simulation simulation = new Simulation();
        ArrayList<Item> itemsPhase1= simulation.loadItems("phase-1.txt");
        ArrayList<Rocket> u1P1Rockets = simulation.loadU1(itemsPhase1);
        ArrayList<Rocket> u2P1Rockets = simulation.loadU2(itemsPhase1);
        int u1Phase1Cost = simulation.runSimulation(u1P1Rockets);
        int u2Phase1Cost = simulation.runSimulation(u2P1Rockets);
        // Display U1 + U2 rocket costs
        System.out.println("Phase 1 U1: " + fmt.format(u1Phase1Cost) + " MM");
        System.out.println("Phase 1 U2: " + fmt.format(u2Phase1Cost) + " MM");
        System.out.println("TOTAL cost Phase1: " + fmt.format(u1Phase1Cost + u2Phase1Cost) + " MM");

        ArrayList<Item> itemsPhase2= simulation.loadItems("phase-2.txt");
        ArrayList<Rocket> u1P2Rockets = simulation.loadU1(itemsPhase2);
        ArrayList<Rocket> u2P2Rockets = simulation.loadU2(itemsPhase2);
        int u1Phase2Cost = simulation.runSimulation(u1P2Rockets);
        int u2Phase2Cost = simulation.runSimulation(u2P2Rockets);
        // Display U1 + U2 rocket costs
        System.out.println("Phase 2 U1: " + fmt.format(u1Phase2Cost) + " MM");
        System.out.println("Phase 2 U2: " + fmt.format(u2Phase2Cost) + " MM");
        System.out.println("TOTAL cost Phase2: " + fmt.format(u1Phase2Cost + u2Phase2Cost) + " MM");
    }
}
