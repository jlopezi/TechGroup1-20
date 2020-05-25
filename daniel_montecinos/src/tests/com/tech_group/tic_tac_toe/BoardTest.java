package com.tech_group.tic_tac_toe;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void aThreeByThreeBoardIsCreated() {
        int expectedSize = 9;
        int actualSize = (int) Arrays.stream(board.getDimension()).flatMap(Arrays::stream).count();
        assertEquals(String.format("Expected a size of %s but found %s", expectedSize, actualSize),
                expectedSize, actualSize);
    }

    @Test
    public void printNewTicTacToeBoard() {
        String[][] expectedTicTacToeBoard = {{"|-|", "|-|", "|-|"}, {"|-|", "|-|", "|-|"}, {"|-|", "|-|", "|-|"}};
        String[][] actualTicTacToeBoard = board.getDimension();
        for (int i = 0; i < expectedTicTacToeBoard.length; i++) {
            assertArrayEquals("Table not initialized with the correct values", expectedTicTacToeBoard[i],
                    actualTicTacToeBoard[i]);
        }
    }

    @Test
    public void aCharacterIsPrintedCorrectlyInBoard() {
        String xChar = "X";
        Position position = new Position(0, 0);
        board.setValueInBoard(xChar, position);
        String[][] expectedTicTacToeBoard = {{"|X|", "|-|", "|-|"}, {"|-|", "|-|", "|-|"}, {"|-|", "|-|", "|-|"}};
        String[][] actualTicTacToeBoard = board.getDimension();
        for (int i = 0; i < expectedTicTacToeBoard.length; i++) {
            assertArrayEquals(String.format("X character wasn't inserted at %s,%s",
                    position.getRow(), position.getColumn()), expectedTicTacToeBoard[i], actualTicTacToeBoard[i]);
        }
    }

    @Test
    public void xCharacterCanBePutInBoard() {
        String xChar = "X";
        Position xPosition = new Position(0, 0);
        assertTrue(String.format("%s wasn't inserted at %s,%s", xChar, xPosition.getRow(), xPosition.getColumn()),
                board.setValueInBoard(xChar, xPosition));
    }

    @Test
    public void oCharacterCanBePutInBoard() {
        String oChar = "O";
        Position oPosition = new Position(1, 1);
        assertTrue(String.format("%s wasn't inserted at %s,%s", oChar, oPosition.getRow(), oPosition.getColumn()),
                board.setValueInBoard(oChar, oPosition));
    }

    @Test
    public void aCharacterCannotBePutInANonEmptyPosition() {
        String oChar = "O";
        Position firstPosition = new Position(0, 0);
        Position secondPosition = new Position(0, 0);
        board.setValueInBoard(oChar, firstPosition);
        assertFalse(String.format("Character should not be inserted at %s, %s",
                secondPosition.getRow(), secondPosition.getColumn()), board.setValueInBoard(oChar, secondPosition));
    }

    @Test
    public void availablePositionsShouldBeReturnedCorrectly() {
        String xChar = "X";
        Position firstPosition = new Position(0, 0);
        Position secondPosition = new Position(1, 0);
        Position thirdPosition = new Position(2, 2);
        board.setValueInBoard(xChar, firstPosition);
        board.setValueInBoard(xChar, secondPosition);
        board.setValueInBoard(xChar, thirdPosition);
        int expectedValue = 6;
        int actualValue = board.getFreePositions();
        assertEquals(String.format("Expected to have %s positions but instead %s", expectedValue, actualValue),
                expectedValue, actualValue);
    }

    @Test
    public void aCharCannotBeInsertInAnInvalidPosition() {
        String xChar = "X";
        Position xPosition = new Position(-1, 3);
        assertFalse(String.format("Value should not be inserted at %s,%s", xPosition.getRow(), xPosition.getColumn()),
                board.setValueInBoard(xChar, xPosition));
    }

    @Test
    public void topLineIsCompleted() {
        String oChar = "O";
        Position firstPosition = new Position(0, 0);
        Position secondPosition = new Position(0, 1);
        Position thirdPosition = new Position(0, 2);
        board.setValueInBoard(oChar, firstPosition);
        board.setValueInBoard(oChar, secondPosition);
        board.setValueInBoard(oChar, thirdPosition);
        assertTrue("Row should be marked as completed", board.areThreeSymbolsCompletedInARow());
    }

    @Test
    public void middleLineIsCompleted() {
        String oChar = "O";
        Position firstPosition = new Position(1, 0);
        Position secondPosition = new Position(1, 1);
        Position thirdPosition = new Position(1, 2);
        board.setValueInBoard(oChar, firstPosition);
        board.setValueInBoard(oChar, secondPosition);
        board.setValueInBoard(oChar, thirdPosition);
        assertTrue("Row should be marked as completed", board.areThreeSymbolsCompletedInARow());
    }

    @Test
    public void bottomLineIsCompleted() {
        String oChar = "O";
        Position firstPosition = new Position(2, 0);
        Position secondPosition = new Position(2, 1);
        Position thirdPosition = new Position(2, 2);
        board.setValueInBoard(oChar, firstPosition);
        board.setValueInBoard(oChar, secondPosition);
        board.setValueInBoard(oChar, thirdPosition);
        assertTrue("Row should be marked as completed", board.areThreeSymbolsCompletedInARow());
    }

    @Test
    public void leftColumnIsCompleted() {
        String xChar = "X";
        Position firstPosition = new Position(0, 0);
        Position secondPosition = new Position(1, 0);
        Position thirdPosition = new Position(2, 0);
        board.setValueInBoard(xChar, firstPosition);
        board.setValueInBoard(xChar, secondPosition);
        board.setValueInBoard(xChar, thirdPosition);
        assertTrue("Column should be marked as completed", board.areThreeSymbolsCompletedInAColumn());
    }

    @Test
    public void centerColumnIsCompleted() {
        String xChar = "X";
        Position firstPosition = new Position(0, 1);
        Position secondPosition = new Position(1, 1);
        Position thirdPosition = new Position(2, 1);
        board.setValueInBoard(xChar, firstPosition);
        board.setValueInBoard(xChar, secondPosition);
        board.setValueInBoard(xChar, thirdPosition);
        assertTrue("Column should be marked as completed", board.areThreeSymbolsCompletedInAColumn());
    }

    @Test
    public void rightColumnIsCompleted() {
        String xChar = "X";
        Position firstPosition = new Position(0, 2);
        Position secondPosition = new Position(1, 2);
        Position thirdPosition = new Position(2, 2);
        board.setValueInBoard(xChar, firstPosition);
        board.setValueInBoard(xChar, secondPosition);
        board.setValueInBoard(xChar, thirdPosition);
        assertTrue("Column should be marked as completed", board.areThreeSymbolsCompletedInAColumn());
    }

    @Test
    public void diagonalIsCompleted() {
        String oChar = "O";
        Position firstPosition = new Position(0, 0);
        Position secondPosition = new Position(1, 1);
        Position thirdPosition = new Position(2, 2);
        board.setValueInBoard(oChar, firstPosition);
        board.setValueInBoard(oChar, secondPosition);
        board.setValueInBoard(oChar, thirdPosition);
        assertTrue("Diagonal should be marked as completed", board.areThreeSymbolsCompletedInADiagonal());
    }
}