package com.tech_group.tic_tac_toe;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  Class that represents a Tic Tac Toe game.
 */
public class TicTacToe {
    private static final String TIE_MESSAGE = "%s and %s, this is a tie!!";
    private static final String PLAYER_WIN_MESSAGE = "Congratulations %s, you win!!";
    private final Scanner scanner;
    private final Board board;
    private final Player playerOne;
    private final Player playerTwo;
    private boolean playerOneTurn;
    private boolean playerTwoTurn;

    /**
     * Creates a new TicTacToe instance.
     *
     * @param playerOne that will play the game.
     * @param playerTwo that will play the game.
     */
    public TicTacToe(final Player playerOne, final Player playerTwo) {
        board = new Board();
        scanner = new Scanner(System.in);
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        playerOneTurn = true;
        playerTwoTurn = false;
    }

    /**
     * Method where all game logic occurs.
     */
    private void playGame() {
        Position position;
        if (playerOneTurn) {
            printPlayerMovementMessage(playerOne);
            position = getUserPosition();
            playerTwoTurn = playerOne.makeMovement(board, position, playerOne.getSymbol()) && noWinner();
        }

        if (playerTwoTurn && board.getFreePositions() != 0) {
            printPlayerMovementMessage(playerTwo);
            position = getUserPosition();
            playerOneTurn = playerTwo.makeMovement(board, position, playerTwo.getSymbol()) && noWinner();
        }
    }

    /**
     * Initializes the game.
     */
    public void initGame() {
        board.printBoard();
        while (board.getFreePositions() > 0 && noWinner()) {
            playGame();
        }
        if (noWinner()) {
            System.out.println(String.format(TIE_MESSAGE, playerOne.getPlayerName(), playerTwo.getPlayerName()));
        } else if (playerOneTurn) {
            System.out.println(String.format(PLAYER_WIN_MESSAGE, playerOne.getPlayerName()));
        } else {
            System.out.println(String.format(PLAYER_WIN_MESSAGE, playerTwo.getPlayerName()));
        }
    }

    /**
     * Asks the player to perform its movement.
     * @param player that will perform its movement.
     */
    private void printPlayerMovementMessage(final Player player) {
        System.out.println(String.format("%s please make your movement: ", player.getPlayerName()));
    }

    /**
     * Gets a position on board where a user will put a value.
     * @return a row/column position where user will put a value.
     */
    private Position getUserPosition() {
        System.out.print("Row: ");
        int row = validatePositionValue();
        System.out.print("Column: ");
        int column = validatePositionValue();
        return new Position(row, column);
    }

    /**
     * Validates if position values have the expected type.
     * @return a position with the expected types.
     */
    private int validatePositionValue() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("That's not a valid number. Please try again: ");
                scanner.next();
            }
        }
    }

    /**
     * Determines if one of the the two players won the game.
     * @return true if any player completed a value in a row, column or diagonal, false otherwise.
     */
    private boolean noWinner() {
        return !board.areThreeSymbolsCompletedInAColumn()
                && !board.areThreeSymbolsCompletedInARow()
                && !board.areThreeSymbolsCompletedInADiagonal();
    }
}
