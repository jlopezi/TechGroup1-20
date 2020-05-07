/*
 * Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jalasoft.
 */
package antoniorojas.tictactoe;

import java.io.IOException;

/** Application tic tac toe
 *  main class
 */
public class TicTacToe {
    public static void main(String[] args) throws IOException {
        Game tictactoeInstance=new Game();
        tictactoeInstance.runGame();
    }
}
