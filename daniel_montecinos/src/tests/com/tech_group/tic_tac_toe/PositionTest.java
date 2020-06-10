package com.tech_group.tic_tac_toe;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void aPositionCanBeCreated() {
        int row = 1;
        int column = 2;
        Position expectedPosition = new Position(1, 2);
        Position actualPosition = new Position(row, column);
        // Position row validation
        assertEquals(String.format("row should be %s not %s", expectedPosition.getRow(), actualPosition.getRow()),
                expectedPosition.getRow(), actualPosition.getRow());

        // Position column validation
        assertEquals(String.format("column should be %s not %s",
                // String.format arguments
                expectedPosition.getColumn(), actualPosition.getColumn()),
                // assertEquals arguments
                expectedPosition.getColumn(), actualPosition.getColumn());
    }
}