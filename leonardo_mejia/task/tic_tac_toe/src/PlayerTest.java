import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;
    /*
     * This method test the player instance.
     */
    @BeforeEach
    public void setUp() {
        player = new Player("Leonardo", "x");
    }

    /*
     * This method test the player name.
     */
    @Test
    @DisplayName("Should compare the player named instanced with the name obtained by the method")
    public void testGetPlayerName() {
        String actualName = player.getName();
        String expectedName = "Leonardo";
        assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("Should compare the player symbol instanced with the symbol obtained by the method")
    public void testGetSymbol() {
        String actualSymbol = player.getSymbol();
        String expectedSymbol = "x";
        assertEquals(expectedSymbol, actualSymbol);
    }
}