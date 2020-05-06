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
        board.board = new String[][]{{"X", "X", "X"}, {null, "O", "O"}, {null, "O", "X"}};
        assertTrue(board.checkWinner());
    }

    @Test
    public void checkFirstRowIsEqual() {
        board.board = new String[][]{{"X", "X", "X"}, {null, "O", "O"}, {null, "O", "X"}};
        assertTrue(board.checkRow());
    }

    @Test
    public void checkSecondRowIsEqual() {
        board.board = new String[][]{{"X", "X", null}, {"O", "O", "O"}, {null, "O", "X"}};
        assertTrue(board.checkRow());
    }

    @Test
    public void checkThirdRowIsEqual() {
        board.board = new String[][]{{"X", "X", null}, {"O", "O", null}, {"X", "X", "X"}};
        assertTrue(board.checkRow());
    }

    @Test
    public void checkAnyRowIsNotEqual() {
        board.board = new String[][]{{null, "X", null}, {"O", "O", null}, {"X", null, "X"}};
        assertFalse(board.checkRow());
    }

    @Test
    public void checkRowWithAllValuesNull() {
        board.board = new String[][]{{null, null, null}, {"O", "O", null}, {"X", null, "X"}};
        assertFalse(board.checkRow());
    }

    @Test
    public void checkFirstColumnIsEqual() {
        board.board = new String[][]{{"X", "X", null}, {"X", "O", "O"}, {"X", "O", "X"}};
        assertTrue(board.checkColumn());
    }

    @Test
    public void checkSecondColumnIsEqual() {
        board.board = new String[][]{{null, "O", null}, {"X", "O", null}, {"X", "O", "X"}};
        assertTrue(board.checkColumn());
    }

    @Test
    public void checkColumnWithAllValuesNull() {
        board.board = new String[][]{{null, "O", null}, {null, "O", "X"}, {null, null, "X"}};
        assertFalse(board.checkColumn());
    }

    @Test
    public void checkThirdColumnIsEqual() {
        board.board = new String[][]{{null, "O", "X"}, {"X", "O", "X"}, {"X", null, "X"}};
        assertTrue(board.checkColumn());
    }

    @Test
    public void checkFirstDiagonal() {
        board.board = new String[][]{{"X", "O", "X"}, {null, "X", null}, {null, null, "X"}};
        assertTrue(board.checkFirstDiagonal());
    }

    @Test
    public void checkFirstDiagonalAllNull() {
        board.board = new String[][]{{null, null, null}, {null, null, null}, {"O", null, null}};
        assertFalse(board.checkFirstDiagonal());
    }

    @Test
    public void checkSecondDiagonal() {
        board.board = new String[][]{{null, "O", "O"}, {null, "O", null}, {"O", null, "X"}};
        assertTrue(board.checkSecondDiagonal());
    }
}