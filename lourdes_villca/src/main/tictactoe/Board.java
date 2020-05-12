/*
 * Copyright (c) 2020. Jalasoft
 */

package tictactoe;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Class that manage the stuffs and information of the board.
 */
public class Board {
    private String[][] board;

    /**
     * Conrstructor that set intitial values
     */
    public Board() {
        board = new String[3][3];
    }

    /**
     * Method that check if there is a winner
     *
     * @return True if there is a winner False otherwise.
     */
    public boolean checkWinner() {
        return checkRow() || checkColumn() || checkFirstDiagonal() || checkSecondDiagonal();
    }

    /**
     * Method that check if a row has the same values.
     *
     * @return True if there is a row with all elements equals, False other wise
     */
    public boolean checkRow() {
        for (String[] row : board) {
            if (!Arrays.asList(row).contains(null) && Arrays.stream(row).distinct().count() == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that check if a column has the same values.
     *
     * @return True if there is a column with all elements equals, False otherwise.
     */
    public boolean checkColumn() {
        for (int i = 0; i < board.length; i++) {
            if (!Arrays.asList(getColumn(i)).contains(null) && Arrays.stream(getColumn(i)).distinct().count() == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method that get an array of column given an index
     *
     * @param index represents the index of the the column
     * @return the Array with all element of the column.
     */
    private String[] getColumn(int index) {
        return Arrays.stream(board).map(arr -> arr[index]).toArray(String[]::new);
    }

    /**
     * Method that check if all elements of the first diagonal are equals.
     *
     * @return True if all elements of the diagonal are equals, False otherwise.
     */
    public boolean checkFirstDiagonal() {
        String[] firstDiagonal = IntStream.range(0, board.length).mapToObj(i -> board[i][i]).toArray(String[]::new);
        return (!Arrays.asList(firstDiagonal).contains(null) && Arrays.stream(firstDiagonal).distinct().count() == 1);
    }

    /**
     * Method that check if all elements of the second diagonal are equals.
     *
     * @return True if all elements of the diagonal are equals, False otherwise.
     */
    public boolean checkSecondDiagonal() {
        String[] secondDiagonal = IntStream.range(0, board.length).mapToObj(i -> board[i][board.length - 1 - i]).toArray(String[]::new);
        return !Arrays.asList(secondDiagonal).contains(null) && Arrays.stream(secondDiagonal).distinct().count() == 1;
    }

    /**
     * Method that set value in a given position.
     * @param x row position
     * @param y column position
     * @param value the value to be set in the position.
     */
    public void setValueAt(int x, int y, String value) {
        board[x][y] = value;
    }

    /**
     * Method that print the board.
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != null) System.out.print(" " + board[i][j] + " ");
                if (j < board.length - 1 && board[i][j] == null){
                    System.out.print("   |");
                }
                else if (j < board.length - 1){
                    System.out.print("|");
                }
            }
            if (i < board.length - 1)
                System.out.println("\n---+---+---");
        }
    }
    /**
     * Method that execute the Player move.
     *
     * @param player Player object.
     */
    public void executePlayerMove(Player player) {
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
            if (verifyValidPosition(row, column)) {
                setValueAt(row, column, player.getSymbol());
                printBoard();
                setValue = true;
                if (checkWinner()) {
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
     * @return true if all values are correct, false otherwise.
     */
    private boolean verifyValidPosition(int row, int column) {
        boolean result = true;
        if (row >= board.length && column >= board.length) {
            System.out.println("Invalid Positions - Please insert integer values and less than 3");
            result = false;
        } else if (board[row][column] != null) {
            System.out.printf("Invalid Position (%s,%s), it is ocuppied", row, column);
            result = false;
        }
        return result;
    }
    public String[][] getBoard() {
        return board;
    }
    public void setBoard(String[][] board) {
        this.board = board;
    }

}
