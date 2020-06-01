import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
    public static void main(String[] args) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board();
        Player player1 = new Player("Player1", "O");
        Player player2 = new Player("Player2", "X");

        Checker checker = new Checker();
        checker.addRule(new StraightLineRule());
        startGame(board, checker, player1, player2, reader);
    }

    private static void startGame(Board board, Checker checker, Player player1, Player player2, BufferedReader reader) throws IOException {
        System.out.println("--- Start Tic Tac Toe ---");
        boolean hasWinnerOrTie = checker.getGameStatus();
        Player currentPlayer = player1;
        while(!hasWinnerOrTie) {
            play(board, currentPlayer, reader);
            currentPlayer = switchPlayer(currentPlayer, player1, player2);
        }
        PrintGameScore(checker);
    }

    private static void play(Board board, Player currentPlayer, BufferedReader reader) throws IOException {
        System.out.println(currentPlayer.getName() + " it's your turn!");
        System.out.println("Add coordinate: x,y");
        System.out.print("coordinate X: ");
        int coordinateX = Integer.parseInt(reader.readLine());
        System.out.print("coordinate Y: ");
        int coordinateY = Integer.parseInt(reader.readLine());
        String symbolPlayer = currentPlayer.getSymbol();
        board.AddPoint(coordinateX, coordinateY, symbolPlayer);
        printBoard(board);
    }

    private static void printBoard(Board board) {
        for (int row = 0; row < board.getMaxRow(); row++) {
            for (int col = 0; col < board.getMaxCol(); col++) {
                System.out.print(" " + board.getValue(row, col));
                if (col != board.getMaxCol() - 1) {
                    System.out.print(" |");
                }
            }
            System.out.print("");
        }
    }

    private static Player switchPlayer(Player currentPlayer, Player player1, Player player2) {
        String currentPlayerName = currentPlayer.getName();
        String firstPlayerName = player1.getName();
        if (currentPlayerName == firstPlayerName) {
            return player2;
        }
        return player1;
    }

    private static void PrintGameScore(Checker checker) {
        GameStatus score = checker.getGameScore();
        System.out.println("--- Game finished! ---");
        if (score.status == "winner") {
            System.out.println(score.playerName + " win!");
        } else {
            System.out.println(score.playerName + " are tied!");
        }
    }
}
