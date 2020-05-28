/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import org.junit.After;

/**
 *
 * @author roly
 */
public class GameTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;
    private Game game;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void checkGameStartWinnerIsNull() {
        game = new Game(new Player("×", ConsoleColors.BLUE),
                new Player("o", ConsoleColors.RED));
         provideInput("1:2");
        assertNull(game.startGame());
    }
}
