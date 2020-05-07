import java.util.List;

public class Checker {
    private List<IRule> rules;
    private GameStatus game;

    public void addRule(IRule rule) {
        rules.add(rule);
    }

    public boolean getGameStatus() {
        return Boolean.parseBoolean(game.status);
    }

    public GameStatus getGameScore() {
        return game;
    }
}
