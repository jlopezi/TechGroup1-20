import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();

        Scanner phase1 = null;
        System.out.println("=====================");
        System.out.println("=       Phase 1     =");
        System.out.println("=====================");
        phase1 = new Scanner(new File("phase1.txt"));
        simulation.loadItems(phase1);
        System.out.println("============================");
        System.out.println("= Rocket U1 Phase 1 Launch =");
        System.out.println("============================");
        simulation.loadU1();
        System.out.println("============================");
        System.out.println("= Rocket U2 Phase 1 Launch =");
        System.out.println("============================");
        simulation.loadU2();

        Scanner phase2 = null;
        System.out.println("\n=====================");
        System.out.println("=       Phase 2     =");
        System.out.println("=====================");
        phase2 = new Scanner(new File("phase2.txt"));
        simulation.loadItems(phase2);
        System.out.println("============================");
        System.out.println("= Rocket U1 Phase 2 Launch =");
        System.out.println("============================");
        simulation.loadU1();
        System.out.println("============================");
        System.out.println("= Rocket U2 Phase 2 Launch =");
        System.out.println("============================");
        simulation.loadU2();
    }
}