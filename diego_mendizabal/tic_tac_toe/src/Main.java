import java.util.Scanner;

public class Main {

    // Prints the board.
    public static void printBoard(char[][] table, char[][] infoTable) {
        for (int fila = 0; fila < 5; fila++){
            for (int col = 0; col < 5; col ++){
                System.out.print(table [fila][col]);
            }
            System.out.print("         ");
            for (int col = 0; col < 5; col ++){
                System.out.print(infoTable[fila][col]);
            }

            System.out.println();
        }
    }

    // Generates the Info boards with the positions.
    public static char[][] generateInfoBoard(){
        char [][] tablero = new char[5][5];
        tablero[0][0] = '1';// pos 1
        tablero[0][1] = '|';
        tablero[0][2] = '2';// pos 2
        tablero[0][3] = '|';
        tablero[0][4] = '3';// pos 3
        tablero[1][0] = '-';
        tablero[1][1] = '-';
        tablero[1][2] = '-';
        tablero[1][3] = '-';
        tablero[1][4] = '-';

        tablero[2][0] = '4';// pos 4
        tablero[2][1] = '|';
        tablero[2][2] = '5';// pos 5
        tablero[2][3] = '|';
        tablero[2][4] = '6';// pos 6
        tablero[3][0] = '-';
        tablero[3][1] = '-';
        tablero[3][2] = '-';
        tablero[3][3] = '-';
        tablero[3][4] = '-';

        tablero[4][0] = '7';//pos 7
        tablero[4][1] = '|';
        tablero[4][2] = '8';//pos 8
        tablero[4][3] = '|';
        tablero[4][4] = '9';//pos 9
        return tablero;
    }

    //Generates the board.
    public static char [][] generateBoard() {
        char [][] tablero = new char[5][5];
        tablero[0][0] = ' ';// pos 1
        tablero[0][1] = '|';
        tablero[0][2] = ' ';// pos 2
        tablero[0][3] = '|';
        tablero[0][4] = ' ';// pos 3
        tablero[1][0] = '-';
        tablero[1][1] = '-';
        tablero[1][2] = '-';
        tablero[1][3] = '-';
        tablero[1][4] = '-';

        tablero[2][0] = ' ';// pos 4
        tablero[2][1] = '|';
        tablero[2][2] = ' ';// pos 5
        tablero[2][3] = '|';
        tablero[2][4] = ' ';// pos 6
        tablero[3][0] = '-';
        tablero[3][1] = '-';
        tablero[3][2] = '-';
        tablero[3][3] = '-';
        tablero[3][4] = '-';

        tablero[4][0] = ' ';//pos 7
        tablero[4][1] = '|';
        tablero[4][2] = ' ';//pos 8
        tablero[4][3] = '|';
        tablero[4][4] = ' ';//pos 9

        return tablero;
    }

    // Manages the player one moves.
    public static void playerOneMove (char [][] board)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Player 1 turn choice position: ");
        int movePosition = in.nextInt();
        playerMove('X', movePosition, board);
    }

    // Manages the player two moves.
    public static void playerTwoMove (char [][] board)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Player 2 turn choice position: ");
        int movePosition = in.nextInt();
        playerMove('O', movePosition, board);
    }

    //Verifies if the board is full.
    public static boolean verifyBoardIsFull(char board [][]) {
        for (int fila = 0; fila < 5; fila++){
            for (int col = 0; col < 5; col ++){
                if(board[fila][col] == ' '){
                    return false;
                }
            }
        }
        System.out.println("It is a Draw!!" );
        return true;
    }

    // Insert a character in the board at specific position
    public static void insertCharacterAtPosition(char playerSymbol, char[][] board, int posFil, int posCol){
        if (board[posFil][posCol] == ' ') {
            board[posFil][posCol] = playerSymbol;
        } else {
            System.out.println("invalid position try again");
            if (playerSymbol == 'X'){
                playerOneMove(board);
            } else {
                playerTwoMove(board);
            }
        }
    }

    // Manages the player moves.
    public static void playerMove(char playerSymbol, int position, char[][] board) {
        switch(position) {
            case 1:
                insertCharacterAtPosition(playerSymbol, board, 0,0);
                break;
            case 2:
                insertCharacterAtPosition(playerSymbol, board, 0,2);
                break;
            case 3:
                insertCharacterAtPosition(playerSymbol, board, 0,4);
                break;
            case 4:
                insertCharacterAtPosition(playerSymbol, board, 2,0);
                break;
            case 5:
                insertCharacterAtPosition(playerSymbol, board, 2,2);
                break;
            case 6:
                insertCharacterAtPosition(playerSymbol, board, 2,4);
                break;
            case 7:
                insertCharacterAtPosition(playerSymbol, board, 4,0);
                break;
            case 8:
                insertCharacterAtPosition(playerSymbol, board, 4,2);
                break;
            case 9:
                insertCharacterAtPosition(playerSymbol, board, 4,4);
                break;
            default:
                System.out.println("invalid position try again");
                if (playerSymbol == 'X'){
                    playerOneMove(board);
                } else {
                    playerTwoMove(board);
                }
                break;
        }
    }

    // Evaluates who won the game if that is the case.
    public static boolean evaluator(char board[][]) {
        if (board[0][0] == board [0][2] && board[0][2] == board[0][4] && board[0][4] != ' ' && board[0][4] != '-'){
            return true;
         } else if(board[2][0] == board [2][2] && board[2][2] == board[2][4] && board[2][4] != ' ' && board[2][4] != '-'){
            return true;
         } else if(board[4][0] == board [4][2] && board[4][2] == board[4][4] && board[4][4] != ' ' && board[4][4] != '-'){
            return true;
         } else if(board[0][0] == board [2][0] && board[4][2] == board[4][0] && board[4][0] != ' ' && board[4][0] != '-'){
            return true;
         } else if(board[0][2] == board [2][2] && board[2][2] == board[4][2] && board[4][2] != ' ' && board[4][2] != '-'){
            return true;
         } else if(board[0][4] == board [2][4] && board[2][4] == board[4][4] && board[4][4] != ' ' && board[4][4] != '-'){
            return true;
         } else if(board[0][0] == board [2][2] && board[2][2] == board[4][4] && board[4][4] != ' ' && board[4][4] != '-'){
            return true;
         } else if(board[0][4] == board [2][2] && board[2][2] == board[4][0] && board[4][0] != ' ' && board[4][0] != '-'){
            return true;
         }

         return false;
    }

    // Manages the game.
    public static void game(char [][] board, char[][] infoBoard){
        boolean endGame = false;
        while(endGame != true){
            playerOneMove(board);
            printBoard(board, infoBoard);
            endGame = evaluator(board);
            if (endGame == true){
                System.out.println("First Player Wins!!!");
                break;
            } else if(verifyBoardIsFull(board)){
                break;
            } else {
                playerTwoMove(board);
                printBoard(board, infoBoard);
                endGame = evaluator(board);
                if (endGame == true) {
                    System.out.println("Second Player Wins!!!");
                    break;
                }
            }
        }
    }

    // Main
    public static void main(String[] args) {

        char [][] board = generateBoard();
        char [][] infoBoard = generateInfoBoard();
        printBoard(board, infoBoard);
        game(board, infoBoard);
    }

}

