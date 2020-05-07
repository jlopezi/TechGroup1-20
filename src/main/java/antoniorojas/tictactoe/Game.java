/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package antoniorojas.tictactoe;

import java.util.Scanner;

public class Game {
    private final int ROWS = 3;
    private final int COLUMNS = 3;
    char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};

    private int x;
    private int y;

    /**
     * This will print the board
     */
    private void showBoard() {
        System.out.println("********Board game********");
        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("" + board[i][j] + "");
                if (j < COLUMNS - 1) {
                    System.out.print(" ║ ");
                }
            }
            System.out.println("");
            if (i < COLUMNS - 1) {
                System.out.println("==========");
            }
        }
    }

    /**
     * It will get slot place based on input
     * @param value int to check slot
     * @return true if slot was found
     */
    private boolean getSlot(int value) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (Character.getNumericValue(board[i][j]) == value) {
                    x = i;
                    y = j;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if slot is available to set it
     * @param value int to check slot
     * @return true if slot can be set
     */
    private boolean checkAvailableSpace(int value) {
        if (getSlot(value)) {
            if (board[x][y] == 'X' || board[x][y] == 'O') {
                System.out.println("Already taken!, please try another one.");
                return false;
            } else {
                return true;
            }
        }
        else{
            return false;
        }
    }

    /**
     * Set slot with X or O
     * @param piece X or O
     */
    private void setSlot(char piece) {
        board[x][y] = piece;
    }

    /**
     * Check if there is a winner rows
     * @param piece X or O
     * @return true if there is a winner rows
     */
    private boolean checkRows (char piece){
        //check rows
        for (int i = 0; i < ROWS; i++)
            if (board[i][0]==piece && board[i][1]==piece && board[i][2]==piece)
                return true;
        return false;
    }

    /**
     * Chec if there is a winner columns
     * @param piece X or O
     * @return true if there is a winner column
     */
    private boolean checkColumns (char piece){
        //check columns
        for (int i = 0; i < COLUMNS; i++)
            if (board[0][i]==piece && board[1][i]==piece && board[2][i]==piece)
                return true;
        return false;
    }

    /**
     * Check if there is a winner diagonals
     * @param piece X or O
     * @return true if there is a winner diagonals
     */
    private boolean checkDiagonals(char piece){
        //diagonal
        if ((board[0][0]==piece && board[1][1]==piece && board[2][2]==piece) ||
        (board[0][2]==piece && board[1][1]==piece && board[2][0]==piece)) {
            return true;
        }
        return false;
    }

    /**
     * Check if there a winner
     * @param piece X or O
     * @return true if there is a winner
     */
    private boolean checkWinner(char piece) {
        return (checkRows(piece) || checkColumns(piece) || checkDiagonals(piece));
    }

    /**
     * This will run the game
     */
    public void runGame(){
        Scanner option=new Scanner(System.in);
        int value;
        boolean valid;
        boolean winner = false;
        char piece;
        for(int turn=1;turn<=9;turn++){
            showBoard();
            piece = (turn%2==0) ? 'X' : 'O';
            do{
                System.out.println("Gamer " + piece +", please select an option (1-9): ");
                value=option.nextInt();
                valid=checkAvailableSpace(value);
            }while(!valid);
            setSlot(piece);
            if(turn>5)
                if(checkWinner(piece)){
                    System.out.println("The winner is : " + piece);
                    winner=true;
                    break;
                }
        }
        if(!winner){
            System.out.println("Tie!");
        }
    }
}
