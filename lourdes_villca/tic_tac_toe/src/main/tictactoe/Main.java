/*
 * Copyright (c) 2020. Jalasoft
 */

package tictactoe;

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
            board.executePlayerMove(player1);
            board.executePlayerMove(player2);
        }
    }
}
