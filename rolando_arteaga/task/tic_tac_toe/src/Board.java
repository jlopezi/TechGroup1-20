import java.util.HashMap;
import java.util.Map;

public class Board {
    private final String[][] board;

    public Board() {
        this.board = new String[3][3];
    }

    public boolean markBoard(Player player, Point point) {
        try {
            if (board[point.getX() - 1][point.getY() - 1] == null) {
                board[point.getX() - 1][point.getY() - 1] = player.getPlayerNumber();
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String hasWinner() {
        for (int i = 0; i < 3; i++) {
            // check horizontal values
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
            // check vertical values
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }

        // check first diagonal values
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        // check second diagonal values
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][0];
        }
        return null;
    }

    private String getValue(int x, int y, Map<String, String> values) {
        String data = board[x][y];
        if (data != null) {
            String color = values.get(data);
            return color + data + ConsoleColors.YELLOW;
        }
        return ConsoleColors.YELLOW + ' ';
    }

    public void paintBoard(Player p1, Player p2) {
        Map<String, String> values = new HashMap<String, String>();
        values.put(p1.getPlayerNumber(), p1.getColor());
        values.put(p2.getPlayerNumber(), p2.getColor());
        System.out.println(ConsoleColors.PURPLE);
        System.out.println("    1     2     3   "+ConsoleColors.YELLOW);
        System.out.println("       |     |      ");
        System.out.print(ConsoleColors.PURPLE);
        System.out.println("1   " + getValue(0, 0, values) + "  |  " + getValue(1, 0, values) + "  |  " + getValue(2, 0, values) + "   ");
        System.out.println("  _____|_____|_____ ");
        System.out.println("       |     |      ");
        System.out.print(ConsoleColors.PURPLE);
        System.out.println("2   " + getValue(0, 1, values) + "  |  " + getValue(1, 1, values) + "  |  " + getValue(2, 1, values) + "   ");
        System.out.println("  _____|_____|_____ ");
        System.out.println("       |     |      ");
        System.out.print(ConsoleColors.PURPLE);
        System.out.println("3   " + getValue(0, 2, values) + "  |  " + getValue(1, 2, values) + "  |  " + getValue(2, 2, values) + "   ");
        System.out.println("       |     |      ");
    }
}
