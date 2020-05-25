package com.tech_group.tic_tac_toe;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void aNewPlayerCanBeCreated() {
        String playerName = "Daniel";
        String playerSymbol = "X";
        Player expectedPlayer = new Player("Daniel", "X");
        Player actualPlayer = new Player(playerName, playerSymbol);
        // Player name validation
        assertEquals(String.format("Name should be %s not %s",
                // String.format arguments
                expectedPlayer.getPlayerName(), actualPlayer.getPlayerName()),
                // assertEquals arguments
                expectedPlayer.getPlayerName(), actualPlayer.getPlayerName());

        // Player symbol validation
        assertEquals(String.format("Symbol should be %s not %s",
                // String.format arguments
                expectedPlayer.getSymbol(), actualPlayer.getSymbol()),
                // assertEquals arguments
                expectedPlayer.getSymbol(), actualPlayer.getSymbol());
    }

    @Test
    public void aPlayerCanInsertSymbolInAnEmptyPosition() {
        Board board = new Board();
        Player player = new Player("Daniel", "X");
        Position position = new Position(0, 0);
        assertTrue("Player should be able to perform the specified movement",
                player.makeMovement(board, position, player.getSymbol()));
    }

    @Test
    public void aPlayerCannotInsertSymbolInAnInvalidPosition() {
        Board board = new Board();
        Player player = new Player("Daniel", "X");
        Position position = new Position(-1, 3);
        assertFalse("Player should be able to perform the specified movement",
                player.makeMovement(board, position, player.getSymbol()));
    }

    @Test
    public void aPlayerCannotInsertSymbolInAnOccupiedPosition() {
        Board board = new Board();
        Player player = new Player("Daniel", "X");
        Position firstPosition = new Position(2, 2);
        board.setValueInBoard(player.getSymbol(), firstPosition);
        Position secondPosition = new Position(2, 2);
        assertFalse("Player should be able to perform the specified movement",
                player.makeMovement(board, secondPosition, player.getSymbol()));
    }
}