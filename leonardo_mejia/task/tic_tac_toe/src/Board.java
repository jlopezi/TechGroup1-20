public class Board {
    private String[][] board;
    private static final int MAX_ROW = 3;
    private static final int MAX_COL = 3;

    public Board() {
        board = new String[MAX_ROW][MAX_COL];
    }

    public String getValue(int row, int col) {
        return board[row][col];
    }

    public static int getMaxCol() {
        return MAX_COL;
    }

    public static int getMaxRow() {
        return MAX_ROW;
    }

    public void AddPoint(int coordinateX, int coordinateY, String symbolPlayer) {
        if (board[coordinateX][coordinateY].isEmpty()) {
            board[coordinateX][coordinateY] = symbolPlayer;
        }
    }
}
