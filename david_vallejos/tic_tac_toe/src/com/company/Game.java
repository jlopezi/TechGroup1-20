package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by David Vallejos
 * The Main class with game logic
 */
public class Game {

    private char character;
    private char[][] grid;
    private static int COLUMN = 3;
    private static int ROW = 3;
    private Scanner scanner;

    /**
     * Game constructor
     */
    public Game() {
        grid = new char[COLUMN][ROW];
        character = 'x';
        scanner = new Scanner(System.in);
        initBoard();
    }

    /**
     * Initialise board with available positions.
     */
    private void initBoard() {
        int value = 1;
        for (int i = 0; i < COLUMN; i++) {
            for (int j = 0; j < ROW; j++) {
                grid[i][j] = (char) (value + '0');
                value++;
            }
        }
    }

    /**
     * Prints board
     */
    private void printBoard() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Places current char at position (i,j)
     * Uses the variable character to decide what char to use
     * @param i the x index of the 2D array grid
     * @param j the y index of the 2D array grid
     * @return boolean: true if play was successful, false if invalid play
     */
    private boolean playAt(int i, int j) {
        if (i >= 3 || j >= 3 || i < 0 || j < 0)
            return false;
        if (grid[i][j] == 'x' || grid[i][j] == 'o') {
            return false;
        }
        grid[i][j] = character;
        return true;
    }

    /**
     * Gets current position comparing at position (i,j)
     *
     * @param position the position that player chose.
     * @return boolean: true if position is was successful play, false if is invalid play
     */
    private boolean getPosition(int position) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (Character.getNumericValue(grid[i][j]) == position) {
                    return playAt(i, j);
                }
            }
        }
        return false;
    }

    /**
     * Changes character turn
     */
    private char nextTurn() {

        if (character == 'x') {
            character = 'o';
        } else {
            character = 'x';
        }

        return character;
    }


    /**
     * Checks if the game has ended either because a player has won, or if the game has ended as a tie.
     * If game hasn't ended the return string has to be "None",
     * If the game ends as tie, the return string has to be "Tie",
     * If the game ends because there's a winner, it should return "X wins" or "O wins" accordingly
     *
     * @return String indicating the outcome of the game: "X wins" or "O wins" or "Tie" or "None"
     */
    private boolean checkGameWinner() {
        return checkRow() || checkColumn() || checkDiagonals();
    }

    /**
     * Checks if the current character win in Diagonal
     *
     * @return boolean: true if there is a 3 in a row, else if there is not
     */
    private boolean checkDiagonals() {
        return (grid[0][0] == character && grid[1][1] == character && grid[2][2] == character) ||
                (grid[0][2] == character && grid[1][1] == character && grid[2][0] == character);
    }

    /**
     * Checks if the current character win in a Column
     *
     * @return boolean: true if there is a 3 in a row, else if there is not
     */
    private boolean checkColumn() {
        for (int j = 0; j < COLUMN; j++)
            if (grid[0][j] == character && grid[1][j] == character && grid[2][j] == character)
                return true;
        return false;
    }

    /**
     * Checks if the current character win in a Row
     *
     * @return boolean: true if there is a 3 in a row, else if there is not
     */
    private boolean checkRow() {
        for (int i = 0; i < ROW; i++)
            if (grid[i][0] == character && grid[i][1] == character && grid[i][2] == character)
                return true;
        return false;
    }

    /**
     * Starts game
     */
    public void playGame() {

        int value;
        for (int turn = 1; turn <= 9; turn++) {
            printBoard();
            do {
                System.out.println("Is the turn of: " + character + ", select an option between 1-9:");
                value = validatePositionValue();
            } while (!getPosition(value));

            if (checkGameWinner()) {
                System.out.println("Winner is: " + character);
                break;
            } else {
                System.out.println("It is a tie!!!");
            }
            nextTurn();
        }
    }

    /**
     * Verifies value introduces by scanner.
     * @return valid value introduced.
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
}
