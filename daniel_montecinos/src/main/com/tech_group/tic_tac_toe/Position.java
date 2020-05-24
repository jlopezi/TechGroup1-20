package com.tech_group.tic_tac_toe;

/**
 * Represents a position in a TicTacToe board.
 */
public class Position {
    private final int row;
    private final int column;

    /**
     * Creates a new Position instance.
     *
     * @param row    that represents a vertical position on board.
     * @param column that represents a horizontal position on board.
     */
    public Position(final int row, final int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets column value.
     *
     * @return column value as integer.
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Gets row value.
     *
     * @return row value as integer.
     */
    public int getRow() {
        return this.row;
    }
}
