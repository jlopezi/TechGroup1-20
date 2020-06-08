import java.util.ArrayList;
import java.util.List;

public class Checker {
    public List<IRule> rules;
    public GameStatus game;

    public Checker(){
        rules = new ArrayList<IRule>();
    }

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
