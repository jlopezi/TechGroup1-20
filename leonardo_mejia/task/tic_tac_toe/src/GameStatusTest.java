import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStatusTest {
    private GameStatus gameStatus;

    /*
     * This method test game status instance.
     */
    @BeforeEach
    public void setUp() {
        gameStatus = new GameStatus();
        gameStatus.status = "winner";
        gameStatus.playerName = "Leonardo";
    }

    @Test
    @DisplayName("Should return a status value as winner")
    void testStatusValue() {
        String expectedValue = "winner";
        String actualValue = gameStatus.status;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    @DisplayName("Should return a player name as Leonardo")
    void testPlayerNameValue() {
        String expectedValue = "Leonardo";
        String actualValue = gameStatus.playerName;
        assertEquals(expectedValue, actualValue);
    }
}