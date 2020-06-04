/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author roly
 */
public class BoardTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void aThreeByThreeBoardIsCreated() {
        int expectedSize = 9;
        int actualSize = this.board.getBoard().length * this.board.getBoard()[0].length;
        assertEquals(String.format("Expected a size of %s but found %s", expectedSize, actualSize),
                expectedSize, actualSize);
    }

    @Test
    public void markOnPositionCorrect() {
        this.board.markBoard(new Player("x", "red"), new Point(1, 1));
        String expectedValue = "x";
        String currentValue = this.board.getBoard()[1][1];
        assertEquals(String.format("Expected mark of %s but found %s", expectedValue, currentValue),
                currentValue, currentValue);
    }

    @Test
    public void cantMarkOnPositionInCorrect() {
        boolean expectedValue = false;
        boolean currentValue = this.board.markBoard(new Player("x", "red"),
                new Point(1, 4));
        assertEquals(String.format("Expected mark %s but found %s", expectedValue, currentValue),
                currentValue, currentValue);
    }

    @Test
    public void checkWinnerOnHorizontalPosition() {
        String expectedValue = "x";
        this.board.markBoard(new Player("x", "red"), new Point(0, 0));
        this.board.markBoard(new Player("x", "red"), new Point(1, 0));
        this.board.markBoard(new Player("x", "red"), new Point(2, 0));
        this.board.paintBoard(new Player("x", "red"), new Player("O", "red"));
        String currentValue = this.board.hasWinner();
        assertEquals(String.format("Expected winner %s but found %s", expectedValue, currentValue),
                currentValue, currentValue);
    }

    @Test
    public void checkWinnerOnVerticalPosition() {
        String expectedValue = "x";
        this.board.markBoard(new Player("x", "red"), new Point(0, 0));
        this.board.markBoard(new Player("x", "red"), new Point(0, 1));
        this.board.markBoard(new Player("x", "red"), new Point(0, 2));
        String currentValue = this.board.hasWinner();
        assertEquals(String.format("Expected winner %s but found %s", expectedValue, currentValue),
                currentValue, currentValue);
    }

    @Test
    public void checkWinnerOnDiagonalPosition() {
        String expectedValue = "x";
        this.board.markBoard(new Player("x", "red"), new Point(0, 0));
        this.board.markBoard(new Player("x", "red"), new Point(1, 1));
        this.board.markBoard(new Player("x", "red"), new Point(2, 2));
        String currentValue = this.board.hasWinner();
        assertEquals(String.format("Expected winner %s but found %s", expectedValue, currentValue),
                currentValue, currentValue);
    }

    @Test
    public void checkWinnerFail() {
        String expectedValue = null;
        this.board.markBoard(new Player("x", "red"), new Point(0, 0));
        this.board.markBoard(new Player("x", "red"), new Point(1, 1));
        String currentValue = this.board.hasWinner();
        assertNull(currentValue);
    }
}
