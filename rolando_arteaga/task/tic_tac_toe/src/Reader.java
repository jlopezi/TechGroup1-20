import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Reader {
    private final InputStreamReader isr = new InputStreamReader(System.in);
    private final BufferedReader br = new BufferedReader(isr);

    public String getPlayerName(Player player) {
        try {
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +
                    "insert name for player # " + player.getColor() + player.getPlayerNumber());
            System.out.print("name: " + player.getColor());
            String name = br.readLine();
            System.out.print(ConsoleColors.RESET);
            return name;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("something went wrong, try again");
            return getPlayerName(player);
        }
    }

    public Point getPoint(Player player) {
        try {
            System.out.println(ConsoleColors.CYAN_BOLD_BRIGHT +
                    "it's time to for player # " + player.getColor() +"("+ player.getPlayerNumber() +") " +player.getName());
            System.out.print(ConsoleColors.RESET);
            System.out.print("coordinate X:Y : " + player.getColor());
            String coordinate = br.readLine();
            System.out.print(ConsoleColors.RESET);
            Point point = Point.createPoint(coordinate);
            return point;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("something went wrong, try again");
            return getPoint(player);
        }
    }

    public void printWinner(Player p) {
        System.out.println(p.getColor() +
                "The Winner " + p.getName() + "("+p.getPlayerNumber()+") !!!!!!!!!!!!!");
    }

    public boolean restart() {
        try {
            System.out.print(ConsoleColors.RESET);
            System.out.println("to start a new game press any key, to exit press x");
            String characters = br.readLine();
            if(characters != null && characters.toUpperCase() == "X"){
                System.exit(0);
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("something went wrong, try again");
            return restart();
        }
    }
}
