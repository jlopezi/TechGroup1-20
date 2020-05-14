/*
 * Copyright (c) 2020. Jalasoft
 */

package tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void checkWinner() {
        board.setBoard(new String[][]{{"X", "X", "X"}, {null, "O", "O"}, {null, "O", "X"}});
        assertTrue(board.checkWinner());
    }

    @Test
    public void checkFirstRowIsEqual() {
        board.setBoard(new String[][]{{"X", "X", "X"}, {null, "O", "O"}, {null, "O", "X"}});
        assertTrue(board.checkRow());
    }

    @Test
    public void checkSecondRowIsEqual() {
        board.setBoard(new String[][]{{"X", "X", null}, {"O", "O", "O"}, {null, "O", "X"}});
        assertTrue(board.checkRow());
    }

    @Test
    public void checkThirdRowIsEqual() {
        board.setBoard(new String[][]{{"X", "X", null}, {"O", "O", null}, {"X", "X", "X"}});
        assertTrue(board.checkRow());
    }

    @Test
    public void checkAnyRowIsNotEqual() {
        board.setBoard(new String[][]{{null, "X", null}, {"O", "O", null}, {"X", null, "X"}});
        assertFalse(board.checkRow());
    }

    @Test
    public void checkRowWithAllValuesNull() {
        board.setBoard(new String[][]{{null, null, null}, {"O", "O", null}, {"X", null, "X"}});
        assertFalse(board.checkRow());
    }

    @Test
    public void checkFirstColumnIsEqual() {
        board.setBoard(new String[][]{{"X", "X", null}, {"X", "O", "O"}, {"X", "O", "X"}});
        assertTrue(board.checkColumn());
    }

    @Test
    public void checkSecondColumnIsEqual() {
        board.setBoard(new String[][]{{null, "O", null}, {"X", "O", null}, {"X", "O", "X"}});
        assertTrue(board.checkColumn());
    }

    @Test
    public void checkColumnWithAllValuesNull() {
        board.setBoard(new String[][]{{null, "O", null}, {null, "O", "X"}, {null, null, "X"}});
        assertFalse(board.checkColumn());
    }

    @Test
    public void checkThirdColumnIsEqual() {
        board.setBoard(new String[][]{{null, "O", "X"}, {"X", "O", "X"}, {"X", null, "X"}});
        assertTrue(board.checkColumn());
    }

    @Test
    public void checkFirstDiagonal() {
        board.setBoard(new String[][]{{"X", "O", "X"}, {null, "X", null}, {null, null, "X"}});
        assertTrue(board.checkFirstDiagonal());
    }

    @Test
    public void checkFirstDiagonalAllNull() {
        board.setBoard(new String[][]{{null, null, null}, {null, null, null}, {"O", null, null}});
        assertFalse(board.checkFirstDiagonal());
    }

    @Test
    public void checkSecondDiagonal() {
        board.setBoard(new String[][]{{null, "O", "O"}, {null, "O", null}, {"O", null, "X"}});
        assertTrue(board.checkSecondDiagonal());
    }
}