package tictactoe;

/**
 * Class that manage the Player stuffs.
 */
public class Player {
    public String nickname;
    public String symbol;

    /**
     * Constructor that initializes values
     *
     * @param nickname Player's Nickname
     * @param symbol   Player's Symbol
     */
    public Player(String nickname, String symbol) {
        this.nickname = nickname;
        this.symbol = symbol;
    }

    /**
     * Method that get the nickname of the player.
     *
     * @return Player Nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Method that set the Player nickname.
     *
     * @param nickname player nickname information.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Method that get the used symbol of the Player.
     *
     * @return the Symbol of the player.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Method that set the symbol to be used for the player.
     *
     * @param symbol player symbol.
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
