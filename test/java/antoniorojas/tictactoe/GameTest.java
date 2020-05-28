/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */

package antoniorojas.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testGetSlot() {
        for (int i=1;i<10;i++) {
            boolean free = game.getSlot(i);
            assertEquals(free, true);
        }
    }

    @Test
    public void testGetSlotFalse() {
        for (int i=10;i<20;i++) {
            boolean free = game.getSlot(i);
            assertEquals(free, false);
        }
    }

    @Test
    public void testAvailableSpace() {
        for (int i=1;i<10;i++) {
            boolean free = game.checkAvailableSpace(i);
            assertEquals(free, true);
        }
    }

    @Test
    public void testAvailableSpaceFalse() {
        for (int i=10;i<20;i++) {
            boolean free = game.checkAvailableSpace(i);
            assertEquals(free, false);
        }
    }

    @Test
    public void testNoWinnerWithPieceXRows() {
        boolean winner = game.checkRows('X');
        assertEquals(winner, false);
    }

    @Test
    public void testNoWinnerWithPiece0Rows() {
        boolean winner = game.checkRows('0');
        assertEquals(winner, false);
    }

    @Test
    public void testNoWinnerWithPieceXColumn() {
        boolean winner = game.checkColumns('X');
        assertEquals(winner, false);
    }

    @Test
    public void testNoWinnerWithPiece0Column() {
        boolean winner = game.checkColumns('0');
        assertEquals(winner, false);
    }

    @Test
    public void testNoWinnerWithPieceXDiagonal() {
        boolean winner = game.checkDiagonals('X');
        assertEquals(winner, false);
    }

    @Test
    public void testNoWinnerWithPiece0Diagonal() {
        boolean winner = game.checkDiagonals('0');
        assertEquals(winner, false);
    }

    @Test
    public void testNoWinnerWithPieceX() {
        boolean winner = game.checkWinner('X');
        assertEquals(winner, false);
    }

    @Test
    public void testNoWinnerWithPiece0() {
       boolean winner = game.checkWinner('0');
       assertEquals(winner, false);
    }

    @Test
    public void testWinnerWithPieceX() {
        game.board[0][0] = 'X';
        game.board[1][0] = 'X';
        game.board[2][0] = 'X';
        boolean winner = game.checkWinner('X');
        assertEquals(winner, true);
    }

    @Test
    public void testWinnerWithPieceXDiagonal() {
        game.board[0][0] = 'X';
        game.board[1][1] = 'X';
        game.board[2][2] = 'X';
        boolean winner = game.checkWinner('X');
        assertEquals(winner, true);
    }

    @Test
    public void testWinnerWithPiece0() {
        game.board[0][0] = '0';
        game.board[1][0] = '0';
        game.board[2][0] = '0';
        boolean winner = game.checkWinner('0');
        assertEquals(winner, true);
    }


    @Test
    public void testWinnerWithPiece0Diagonal() {
        game.board[0][0] = '0';
        game.board[1][1] = '0';
        game.board[2][2] = '0';
        boolean winner = game.checkWinner('0');
        assertEquals(winner, true);
    }
}