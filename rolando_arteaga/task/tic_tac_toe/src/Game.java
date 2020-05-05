public class Game {
    private final Reader console;
    private Board boardGame;
    private final Player playerBlue;
    private final Player playerGreen;

    public Game(Player playerBlue, Player playerGreen) {
        this.console = new Reader();
        playerBlue.setName(console.getPlayerName(playerBlue));
        playerGreen.setName(console.getPlayerName(playerGreen));
        this.playerBlue = playerBlue;
        this.playerGreen = playerGreen;
        this.startGame();
    }

    public void getPointPlayer(Player p) {
        Point point = this.console.getPoint(p);
        boolean isMark = boardGame.markBoard(p, point);
        if (!isMark) {
            System.err.println("invalid point, try again ");
            this.getPointPlayer(p);
        }
    }

    public void startGame() {
        boardGame = new Board();
        boardGame.paintBoard(playerBlue, playerGreen);
        for (int i = 0; boardGame.hasWinner() == null; i++) {
            if (9 <= i) {
                System.err.println("both players lost, try again");
                break;
            }
            this.getPointPlayer(i % 2 == 0 ? this.playerBlue : this.playerGreen);
            boardGame.paintBoard(playerBlue, playerGreen);
        }
        String winner = boardGame.hasWinner();
        if(winner != null) {
            console.printWinner(winner == playerBlue.getPlayerNumber() ? playerBlue : playerGreen );
        }
        if(console.restart()) {
            this.startGame();
        }
    }
}
