public class StraightLineRule implements IRule {

    @Override
    public boolean verify(Board board, Player player) {
        return verifyHorizontal(board, player) || verifyVertical(board, player);
    }

    private boolean verifyHorizontal(Board board, Player player) {
        boolean wonTheGame = false;
        String playerSymbol = player.getSymbol();
        for (int row = 0; row < board.getMaxRow(); row++ ) {
            wonTheGame = verifyRow(board, row, playerSymbol);
            if (wonTheGame) {
                break;
            }
        }
        return wonTheGame;
    }

    private boolean verifyVertical(Board board, Player player) {
        return false;
    }

    private boolean verifyRow(Board board, int row, String symbol) {
        for (int col = 0; col < board.getMaxCol(); col++) {
            if (symbol != board.getValue(row, col)) {
                return false;
            }
        }
        return true;
    }
}
