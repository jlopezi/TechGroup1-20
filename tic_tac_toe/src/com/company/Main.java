    package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        Scanner keyboard=new Scanner(System.in);
        String player1,player2;
        System.out.println("Type tha player1's name " );
        player1=keyboard.next();
        System.out.println("Type tha player2's name " );
        player2=keyboard.next();
	    Tictactoe newgame= new Tictactoe(player1,player2);
        newgame.game_on();
    }
}


