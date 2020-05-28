import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class TestTicTacToe {

    private TicTacToe game;

    @Before
    public void setUp(){
        game = new TicTacToe();
    }

    @Test
    public void testIsNotFull(){
        boolean isFull = game.isTableFull();
        assertFalse(isFull);
    }

    @Test
    public void testIsFull() {
        char[][] actualTable = {{'x', 'o', 'x'}, {'x', 'o', 'x'}, {'o', 'x', 'o'}};
        game.setTable(actualTable);
        boolean isFull = game.isTableFull();
        assertTrue(isFull);
    }

    @Test
    public void testChangePlayerX(){
        game.changePlayer();
        char player = game.getCurrentPlayer();
        assertEquals(player, 'o');
    }

    @Test
    public void testChangePlayerO(){
        game.setCurrentPlayer('o');
        game.changePlayer();
        char player = game.getCurrentPlayer();
        assertEquals(player, 'x');
    }

    @Test
    public void testIsNotValid(){
        boolean not_valid = game.isValid(3, 2);
        assertFalse(not_valid);
    }

    @Test
    public void testIsValid(){
        boolean valid = game.isValid(0, 2);
        assertTrue(valid);
    }

    @Test
    public void testPutMark(){
        char[][] expectedTable = {{'x', '-', 'o'}, {'-', '-', '-'}, {'-', '-', '-'}};
        char[][] actualTable = {{'x', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        game.setTable(actualTable);
        game.changePlayer();
        boolean validMark = game.putMark(0, 2);
        assertEquals(validMark, true);
        assertArrayEquals(game.getTable(), expectedTable);
    }

    @Test
    public void testNotPutMark(){
        char[][] actualTable = {{'x', '-', '-'}, {'-', 'o', '-'}, {'-', '-', '-'}};
        game.setTable(actualTable);
        boolean validMark = game.putMark(1, 1);
        assertFalse(validMark);
    }

    @Test
    public void testIsTied(){
        char[][] actualTable = {{'x', 'o', 'x'}, {'x', 'o', 'x'}, {'o', 'x', 'o'}};
        game.setTable(actualTable);
        boolean winner = game.isWinner();
        assertFalse(winner);
    }

    @Test
    public void testIsRowWinner(){
        char[][] actualTable = {{'o', 'o', 'o'}, {'x', 'o', 'x'}, {'o', 'x', 'x'}};
        game.setTable(actualTable);
        boolean winner = game.isWinner();
        assertTrue(winner);
    }

    @Test
    public void testIsColWinner(){
        char[][] actualTable = {{'o', 'o', 'x'}, {'x', 'o', 'x'}, {'o', 'x', 'x'}};
        game.setTable(actualTable);
        boolean winner = game.isWinner();
        assertTrue(winner);
    }

    @Test
    public void testIsDiagonalWinner(){
        char[][] actualTable = {{'o', 'x', 'o'}, {'x', 'o', 'x'}, {'o', 'x', 'o'}};
        game.setTable(actualTable);
        boolean winner = game.isWinner();
        assertTrue(winner);
    }
}
