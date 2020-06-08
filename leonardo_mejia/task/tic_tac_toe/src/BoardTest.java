import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    /*
     * This method test the board instance.
     */
    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("Should return a null board value at row 0 and column 0")
    void testGetValue() {
        int row = 0;
        int col = 0;
        String actualValue = board.getValue(row, col);
        assertNull(actualValue);
    }

    @Test
    @DisplayName("Should return 3 as max column value")
    void testGetMaxCol() {
        int expectedValue = 3;
        int actualValue = board.getMaxCol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Should return 3 as max row value")
    void testGetMaxRow() {
        int expectedValue = 3;
        int actualValue = board.getMaxRow();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Should return x as board symbol at row 0 and column 0 afted added the point")
    void testAddPoint() {
        int row = 0;
        int col = 0;
        String expectedSymbol = "x";
        board.AddPoint(row, col, expectedSymbol);
        String actualSymbol = board.getValue(row, col);
        assertEquals(expectedSymbol, actualSymbol);
    }
}