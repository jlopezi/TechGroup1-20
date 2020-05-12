public class TicTacToe {
    private char[][] table;
    private char currentPlayer;

    public TicTacToe(){
        table = new char [3][3];
        currentPlayer = 'x';
        createTable();
    }

    public void createTable(){
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = '-';
            }
        }
    }

    public void printTable(){
        System.out.println("-------------");
        for(int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isTableFull(){
        boolean isFull = true;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == '-'){
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    public char getCurrentPlayer(){
        return currentPlayer;
    }

    public void changePlayer(){
        if (currentPlayer == 'x'){
            currentPlayer = 'o';
        }
        else{
            currentPlayer = 'x';
        }
    }

    public boolean isValid(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (table[row][col] == '-') {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean putMark(int row, int col){
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (table[row][col] == '-'){
                    table[row][col] = currentPlayer;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkRowCol(char x1, char x2, char x3){
        return ((x1 != '-' && x1 == x2 && x2 == x3));
    }

    private boolean checkRows(){
        for(int i = 0; i < 3; i++) {
            if (checkRowCol(table[i][0], table[i][1], table[i][2])){
                return true;
            }
        }
        return false;
    }

    private boolean checkCols(){
        for(int i = 0; i < 3; i++) {
            if (checkRowCol(table[0][i], table[1][i], table[2][i])){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(){
        if (checkRowCol(table[0][0], table[1][1], table[2][2]) || checkRowCol(table[0][2], table[1][1], table[2][0])){
            return true;
        }
        return false;
    }

    public boolean isWinner() {
        return (checkRows() || checkCols() || checkDiagonals());
    }

}
