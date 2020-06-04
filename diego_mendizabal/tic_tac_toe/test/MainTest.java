import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();

    /**
     * Verifies if the info board was generated
     */
    @Test
    void generateInfoBoard() {
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

        char [][] infoBoard = main.generateInfoBoard();

        boolean equals = true;

        for (int fila = 0; fila < 5; fila++){
            for (int col = 0; col < 5; col ++) {
                if(infoBoard[fila][col] != tablero[fila][col]){
                    equals = false;
                    break;
                }
            }
            if(!equals){
                break;
            }
        }
        assertTrue(equals, "the tables should have the same values");
    }

    /**
     * Verifies if the board is generated
     */
    @Test
    void generateBoard() {
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

        char [][] board = main.generateBoard();

        boolean equals = true;

        for (int fila = 0; fila < 5; fila++){
            for (int col = 0; col < 5; col ++) {
                if(board[fila][col] != tablero[fila][col]){
                    equals = false;
                    break;
                }
            }
            if(!equals){
                break;
            }
        }
        assertTrue(equals, "the tables should have the same values");
    }

    /**
     * Verifies if the player can place a move with symbol X
     */
    @Test
    void playerMoveX() {
        char [][] board = main.generateBoard();
        main.playerMove('x',1, board);
        assertEquals(board[0][0], 'x', "values does not match verify insertion position");
    }

    /**
     * Verifies if the player can place a move with symbol O
     */
    @Test
    void playerMove0() {
        char [][] board = main.generateBoard();
        main.playerMove('0',9, board);
        assertEquals(board[4][4], '0', "values does not match verify insertion position");
    }

    /**
     * Verifies if the board is full
     */
    @Test
    void verifyBoardIsFull() {
        char [][] tablero = main.generateBoard();
        tablero[0][0] = 'X';// pos 1
        tablero[0][2] = 'O';// pos 2
        tablero[0][4] = 'X';// pos 3
        tablero[2][0] = 'O';// pos 4
        tablero[2][2] = 'X';// pos 5
        tablero[2][4] = 'O';// pos 6
        tablero[4][0] = 'O';// pos 7
        tablero[4][2] = 'X';// pos 8
        tablero[4][4] = 'O';// pos 9
        assertTrue(main.verifyBoardIsFull(tablero), "board verification fails review board data");
    }

    /**
     * Verifies if the board is not full
     */
    @Test
    void verifyBoardIsNotFull() {
        char [][] tablero = main.generateBoard();
        tablero[0][0] = 'X';// pos 1
        tablero[0][2] = 'O';// pos 2
        tablero[0][4] = 'X';// pos 3
        tablero[2][0] = 'O';// pos 4
        tablero[2][2] = ' ';// pos 5
        tablero[2][4] = 'O';// pos 6
        tablero[4][0] = 'O';// pos 7
        tablero[4][2] = ' ';// pos 8
        tablero[4][4] = 'O';// pos 9
        assertFalse(main.verifyBoardIsFull(tablero), "board verification fails review board data");
    }

    /**
     * Verifies insert a character at certain position in the board
     */
    @Test
    void insertCharacterAtPosition() {
        char [][] board = main.generateBoard();
        main.insertCharacterAtPosition('X', board,2,2, false);
        assertEquals(board[2][2], 'X', "values was not inserted");
    }

    /**
     * Verifies insert a character at certain position that is already taken
     */
    @Test
    void insertCharacterAtTakenPositionPosition() {
        char [][] board = main.generateBoard();
        main.insertCharacterAtPosition('X', board,2,2, false);
        main.insertCharacterAtPosition('O', board,2,2, true);
        assertEquals(board[2][2], 'X', "values O was inserted");
    }

    /**
     * Verifies insert a character at invalid position in the board
     */
    @Test
    void insertCharacterAtInvalidPosition() {
        char [][] board = main.generateBoard();
        main.insertCharacterAtPosition('X', board,0,1, true);
        assertEquals(board[0][1], '|', "values was not inserted");
    }

    /**
     * evaluates if the game is over at win for Diagonal line
     */
    @Test
    void evaluatorDiagonal() {
        char [][] board = main.generateBoard();
        main.playerMove('0',1, board);
        main.playerMove('0',5, board);
        main.playerMove('0',9, board);
        assertTrue(main.evaluator(board), "review evaluator at positions 1,5,9");
    }

    /**
     * evaluates if the game is over at win for Column line
     */
    @Test
    void evaluatorWinFirstColumn() {
        char [][] board = main.generateBoard();
        main.playerMove('0',1, board);
        main.playerMove('0',4, board);
        main.playerMove('0',7, board);
        assertTrue(main.evaluator(board), "review evaluator at positions 1,4,7");
    }

    /**
     * evaluates if the game is over at win for Column line
     */
    @Test
    void evaluatorWinSecondColumn() {
        char [][] board = main.generateBoard();
        main.playerMove('0',2, board);
        main.playerMove('0',5, board);
        main.playerMove('0',8, board);
        assertTrue(main.evaluator(board), "review evaluator at positions 1,4,7");
    }

    /**
     * evaluates if the game is over at win for Column line
     */
    @Test
    void evaluatorWinThirdColumn() {
        char [][] board = main.generateBoard();
        main.playerMove('0',3, board);
        main.playerMove('0',6, board);
        main.playerMove('0',9, board);
        assertTrue(main.evaluator(board), "review evaluator at positions 1,4,7");
    }

    /**
     * evaluates if the game is over at win for Row line
     */
    @Test
    void evaluatorWinFirstRow() {
        char [][] board = main.generateBoard();
        main.playerMove('0',1, board);
        main.playerMove('0',2, board);
        main.playerMove('0',3, board);
        assertTrue(main.evaluator(board), "review evaluator at positions 1,2,3");
    }

    /**
     * evaluates if the game is over at win for Row line
     */
    @Test
    void evaluatorWinSecondRow() {
        char [][] board = main.generateBoard();
        main.playerMove('0',4, board);
        main.playerMove('0',5, board);
        main.playerMove('0',6, board);
        assertTrue(main.evaluator(board), "review evaluator at positions 1,2,3");
    }
    /**
     * evaluates if the game is over at win for Row line
     */
    @Test
    void evaluatorWinThirdRow() {
        char [][] board = main.generateBoard();
        main.playerMove('0',7, board);
        main.playerMove('0',8, board);
        main.playerMove('0',9, board);
        assertTrue(main.evaluator(board), "review evaluator at positions 1,2,3");
    }
}