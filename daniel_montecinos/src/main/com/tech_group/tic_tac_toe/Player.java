package com.tech_group.tic_tac_toe;

/**
 * Represents a TicTacToe's player.
 */
public class Player {
    private final String name;
    private final String symbol;

    /**
     * Creates a new player.
     *
     * @param name   of player.
     * @param symbol that player will use for game, can be either 'X' or 'O'.
     */
    Player(final String name, final String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    /**
     * Gets player's name.
     *
     * @return player name as String.
     */
    public String getPlayerName() {
        return this.name;
    }

    /**
     * Gets player's symbol.
     *
     * @return player symbol as String.
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Method used by a player to make its game movement.
     *
     * @param board    used to play the game.
     * @param position on board where player will put its symbol.
     * @param symbol   used by the player in the game.
     * @return true if symbol where put on board, false otherwise.
     */
    public boolean makeMovement(final Board board, final Position position, final String symbol) {
        return board.setValueInBoard(symbol, position);
    }
}
