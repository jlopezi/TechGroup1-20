import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightLineRuleTest {

    private Board board;
    private Player player;
    private StraightLineRule rule;

    /*
     * This method test the player instance.
     */
    @BeforeEach
    public void setUp() {
        player = new Player("Leonardo", "x");
        board = new Board();
        rule = new StraightLineRule();
    }

    /*
     * This method test the validation of rule.
     */
    @Test
    @DisplayName("Should return false when the player did not win the game")
    public void testVerifyRule() {
        boolean actualResult = rule.verify(board, player);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Should return true when the player won the game")
    public void testVerifyRuleOnWinnerPlayer() {
        int row = 0;
        int column = 0;
        String symbol = "x";
        board.AddPoint(row, column, symbol);
        board.AddPoint(row, ++column, symbol);
        board.AddPoint(row, ++column, symbol);
        boolean actualResult = rule.verify(board, player);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }
}