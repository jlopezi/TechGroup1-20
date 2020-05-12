import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    // Simulation
    Simulation simulation = new Simulation();
    // Load Files
    ArrayList<Item> phase1 = simulation.loadItems("files/Phase-1.txt");
    ArrayList<Item> phase2 = simulation.loadItems("files/Phase-2.txt");
  
    // Load rockets Phase-1
    ArrayList<Rocket> rockets1U1 = simulation.loadU1(phase1);
    ArrayList<Rocket> rockets1U2 = simulation.loadU2(phase1);

    // Load rockets Phase-2
    ArrayList<Rocket> rockets2U1 = simulation.loadU1(phase2);
    ArrayList<Rocket> rockets2U2 = simulation.loadU2(phase2);

    // Cost Phase-1
    int costPhase1U1 = simulation.runSimulation(rockets1U1);
    int costPhase1U2 = simulation.runSimulation(rockets1U2);
    System.out.println("Phase 1 for U1 rockets will cost: " + costPhase1U1);
    System.out.println("Phase 1 for U2 rockets will cost: " + costPhase1U2);
    
    // Cost Phase-2
    int costPhase2U1 = simulation.runSimulation(rockets2U1);
    int costPhase2U2 = simulation.runSimulation(rockets2U2);
    System.out.println("Phase 2 for U1 rockets will cost: " + costPhase2U1);
    System.out.println("Phase 2 for U2 rockets will cost: " + costPhase2U2);
   
  }
}