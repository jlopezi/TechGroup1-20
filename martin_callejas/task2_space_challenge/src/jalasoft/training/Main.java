package jalasoft.training;

public class Main {

    public static void main(String[] args) {
        Simulation mySimulation = new Simulation();

        int fleetU1budget = mySimulation.runSimulation(mySimulation.loadU1(mySimulation.loadItems("phase-1.txt")))
                            + mySimulation.runSimulation(mySimulation.loadU1(mySimulation.loadItems("phase-2.txt")));
        System.out.println(String.format("U1 Rockets fleet total budget: $%d Million", fleetU1budget));

        int fleetU2budget = mySimulation.runSimulation(mySimulation.loadU2(mySimulation.loadItems("phase-1.txt")))
                + mySimulation.runSimulation(mySimulation.loadU2(mySimulation.loadItems("phase-2.txt")));
        System.out.println(String.format("U2 Rockets fleet total budget: $%d Million", fleetU2budget));

    }
}
