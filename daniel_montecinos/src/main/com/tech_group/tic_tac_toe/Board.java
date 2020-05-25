package com.tech_group.tic_tac_toe;

import java.util.Arrays;

/**
 * Class that represents a tic tac toe board.
 */
public class Board {
    private static final String INVALID_POSITION = "%s,%s is not a valid position. Please try again.";
    private static final String SYMBOL_NOT_ADDED_ON_BOARD = "You cannot add %s in %s, %s";
    private static final String SYMBOL_ADDED_ON_BOARD = "%s added to %s, %s";
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    public static final String PIPE = "\\|";
    public static final String EMPTY_SPACE = "";
    public static final String X_OR_O = "XXX|OOO";
    private final String[][] dimension;
    private int freePositions;

    /**
     * Public constructor.
     */
    public Board() {
        dimension = new String[ROWS][COLUMNS];
        freePositions = ROWS * COLUMNS;
        initializeBoard();
    }

    /**
     * Prints board in console output.
     */
    public void printBoard() {
        System.out.println(String.format("%5s%3s%3s", 0, 1, 2));
        for (int i = 0; i < ROWS; i++) {
            System.out.print(String.format("%2s ", i));
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(dimension[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Set value in board if position >=0 and <=2.
     *
     * @param value    that will be put on position. Could be both 'X' or 'O'.
     * @param position represents a position in board.
     * @return true if value was put in board, false otherwise.
     */
    public boolean setValueInBoard(final String value, final Position position) {
        if (!validPosition(position)) {
            System.out.println(String.format(INVALID_POSITION, position.getRow(), position.getColumn()));
            printBoard();
            return false;
        } else if (valueOnBoard(position)) {
            System.out.println(String.format(SYMBOL_NOT_ADDED_ON_BOARD, value, position.getRow(),
                    position.getColumn()));
            printBoard();
            return false;
        } else {
            dimension[position.getRow()][position.getColumn()] =
                    dimension[position.getRow()][position.getColumn()].replace("-", value);
            System.out.println(String.format(SYMBOL_ADDED_ON_BOARD, value, position.getRow(), position.getColumn()));
            freePositions--;
            printBoard();
            return true;
        }
    }

    /**
     * Gets the amount of free positions available in the board.
     *
     * @return the amount of free positions where we can put a value. ('X' or 'O').
     */
    public int getFreePositions() {
        return freePositions;
    }

    /**
     * Verifies if a pattern o three X's or O's were completed in a row.
     *
     * @return true if three symbols were completed in a row, false otherwise.
     */
    public boolean areThreeSymbolsCompletedInARow() {
        String top = (dimension[0][0] + dimension[0][1] + dimension[0][2]).replaceAll(PIPE, EMPTY_SPACE);
        String middle = (dimension[1][0] + dimension[1][1] + dimension[1][2]).replaceAll(PIPE, EMPTY_SPACE);
        String bottom = (dimension[2][0] + dimension[2][1] + dimension[2][2]).replaceAll(PIPE, EMPTY_SPACE);
        return top.matches(X_OR_O) || middle.matches(X_OR_O) || bottom.matches(X_OR_O);
    }

    /**
     * Verifies if a pattern o three X's or O's were completed in a column.
     *
     * @return true if three symbols were completed in a column, false otherwise.
     */
    public boolean areThreeSymbolsCompletedInAColumn() {
        String left = (dimension[0][0] + dimension[1][0] + dimension[2][0]).replaceAll(PIPE, EMPTY_SPACE);
        String center = (dimension[0][1] + dimension[1][1] + dimension[2][1]).replaceAll(PIPE, EMPTY_SPACE);
        String right = (dimension[0][2] + dimension[1][2] + dimension[2][2]).replaceAll(PIPE, EMPTY_SPACE);
        return left.matches(X_OR_O) || center.matches(X_OR_O) || right.matches(X_OR_O);
    }

    /**
     * Verifies if a pattern o three X's or O's were completed in a diagonal.
     *
     * @return true if three symbols were completed in a diagonal, false otherwise.
     */
    public boolean areThreeSymbolsCompletedInADiagonal() {
        String diagonal = (dimension[0][0] + dimension[1][1] + dimension[2][2]).replaceAll(PIPE, EMPTY_SPACE);
        return diagonal.matches(X_OR_O);
    }

    /**
     * Gets tic tac toe board.
     * @return tic tac toe board.
     */
    public String[][] getDimension() {
        return dimension;
    }

    /**
     * Initializes the board, each position will be filled out with '|-|' to represent the positions in Dashboard.
     */
    private void initializeBoard() {
        for (String[] position : dimension) {
            Arrays.fill(position, "|-|");
        }
    }

    /**
     * Determines if a value already exists on the board.
     *
     * @param position where value will be checked.
     * @return true if a value exist in the specified position, false otherwise.
     */
    private boolean valueOnBoard(final Position position) {
        return dimension[position.getRow()][position.getColumn()].matches("\\|[XO]\\|");
    }

    /**
     * Determines if positions passed as argument is a valid one.
     *
     * @param position to validate.
     * @return true if position exists on the board, false otherwise.
     */
    private boolean validPosition(final Position position) {
        //we subtract 1 because the user can only use values equal to or greater than 0
        // and less than or equal to 2 for rows and columns.
        return position.getRow() >= 0 && position.getRow() <= ROWS - 1
                && position.getColumn() >= 0 && position.getColumn() <= COLUMNS - 1;
    }
}
