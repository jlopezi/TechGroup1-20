package tictactoe;

import java.util.Scanner;

public class Main {
    /**
     * Main method to run the game.
     *
     * @param args
     */
    public static void main(String[] args) {

        Board board = new Board();
        System.out.println("STARTING --- TIC TAC TOE GAME");
        board.printBoard();
        Player player1 = new Player("A", "X");
        Player player2 = new Player("B", "O");
        System.out.println("\nPlayer: " + player1.getNickname() + " - Symbol: " + player1.getSymbol());
        System.out.println("Player: " + player2.getNickname() + " - Symbol: " + player2.getSymbol());

        while (!board.checkWinner()) {
            executePlayerMove(player1, board);
            executePlayerMove(player2, board);
        }
    }

    /**
     * Method that execute the Player move.
     *
     * @param player Player object.
     * @param board  tic tac toe board.
     */
    public static void executePlayerMove(Player player, Board board) {
        boolean setValue = false;
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int column = 0;
        while (!setValue) {
            System.out.println("\nTurn Player: " + player.getNickname() + " - Symbol: " + player.getSymbol());
            System.out.print("Insert row position: ");
            row = scanner.nextInt();
            System.out.print("Insert column position: ");
            column = scanner.nextInt();
            if (verifyValidPosition(row, column, board)) {
                board.setValueAt(row, column, player.symbol);
                board.printBoard();
                setValue = true;
                if (board.checkWinner()) {
                    System.out.println("\nEND GAME --- WIN PLAYER: " + player.getNickname());
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Method that validate the inserted position.
     *
     * @param row    row position.
     * @param column column position.
     * @param board  tic tac toe board
     * @return true if all values are correct, false otherwise.
     */
    public static boolean verifyValidPosition(int row, int column, Board board) {
        boolean result = true;
        if (row >= board.board.length && column >= board.board.length) {
            System.out.println("Invalid Positions - Please insert integer values and less than 3");
            result = false;
        } else if (board.board[row][column] != null) {
            System.out.printf("Invalid Position (%s,%s), it is ocuppied", row, column);
            result = false;
        }
        return result;
    }
}
