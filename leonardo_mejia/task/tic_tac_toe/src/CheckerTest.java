import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    private Checker checker;

    /*
     * This method test the board instance.
     */
    @BeforeEach
    public void setUp() {
        checker = new Checker();
        checker.game = new GameStatus();
        checker.game.playerName = "Leonardo";
        checker.game.status = "winner";
    }

    @Test
    @DisplayName("Should return a quantity of rule after added the new rule")
    void testAddRule() {
        int expectedValue = 0;
        int actualValue = checker.rules.size();
        assertEquals(expectedValue, actualValue);
        StraightLineRule straightRule = new StraightLineRule();
        checker.addRule(straightRule);
        expectedValue = 1;
        actualValue = checker.rules.size();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Should return false when the game status has some empty value")
    void getGameStatus() {
        boolean expectedValue = false;
        boolean actualValue = checker.getGameStatus();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Should return a player when get the game score")
    void getGameScore() {
        GameStatus expectedValue = new GameStatus();
        expectedValue.status = "winner";
        expectedValue.playerName = "Leonardo";
        GameStatus actualValue = checker.getGameScore();
        assertEquals(expectedValue.status, actualValue.status);
        assertEquals(expectedValue.playerName, actualValue.playerName);
    }
}