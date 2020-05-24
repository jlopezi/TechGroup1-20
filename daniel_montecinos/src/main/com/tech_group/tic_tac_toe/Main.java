package com.tech_group.tic_tac_toe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Main class that executes the game.
 */
public final class Main {
    private static final String X = "X";
    private static final String O = "O";
    private static final Scanner SCANNER;
    private static final List<String> SYMBOLS;

    /**
     * Private Constructor.
     * This was set to solve issue with checkstyle.
     */
    private Main() {
        //not called
    }

    static {
        SCANNER = new Scanner(System.in);
        SYMBOLS = new ArrayList<>();
        SYMBOLS.add(X);
        SYMBOLS.add(O);
    }

    /**
     * Main method.
     *
     * @param args passed via command line.
     */
    public static void main(final String[] args) {
        System.out.println("Welcome to TicTacToe Game!!!");
        System.out.print("Player One ");
        String playerName = getUserName();
        String playerChoice = getUserSymbol();
        Player playerOne = new Player(playerName, playerChoice);
        System.out.print("Player Two ");
        playerName = getUserName();
        playerChoice = SYMBOLS.get(0);
        Player playerTwo = new Player(playerName, playerChoice);
        System.out.println(String.format("%s will play with '%s', that means %s will play with '%s'",
                playerOne.getPlayerName(), playerOne.getSymbol(), playerTwo.getPlayerName(), playerTwo.getSymbol()));
        TicTacToe ticTacToe = new TicTacToe(playerOne, playerTwo);
        ticTacToe.initGame();
    }

    /**
     * Gets user name from the console input.
     *
     * @return user name as String.
     */
    private static String getUserName() {
        System.out.print("Name: ");
        return SCANNER.nextLine();
    }

    /**
     * Gets user symbol from the console input.
     *
     * @return user symbol as String.
     */
    private static String getUserSymbol() {
        String choice = X;
        while (SYMBOLS.size() > 1) {
            System.out.print("Will play with 'X' or 'O'?: ");
            choice = SCANNER.nextLine().toUpperCase();
            if (!SYMBOLS.contains(choice)) {
                System.out.println(String.format("%s is not a valid option. Please try again.", choice));
            } else {
                SYMBOLS.remove(choice);
            }
        }
        return choice;
    }
}
