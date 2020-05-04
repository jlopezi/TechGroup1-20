package com.company;
import java.util.Scanner;

public class Tictactoe {
    final int cols=3;
    final int rows=3;
    private String [][] board;
    private String player1;
    private String player2;
    private int num_of_plays;
    Tictactoe(String player1, String player2) {
        this.board = new String[this.cols][this.rows];
        this.player1 = player1;
        this.player2 = player2;
        this.num_of_plays=0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.board[i][j] = "";
            }
        }
    }
    public void printboard()
    {
        System.out.println("+--+--+--+");
        for (int i=0;i<this.rows;i++)
        {
            System.out.print("| ");
            for (int j=0;j<this.cols;j++)
            {
                if (this.board[i][j].length()>0)
                    System.out.print(this.board[i][j]);
                else
                    System.out.print(" ");
                System.out.print("| ");
            }
            System.out.println("");
            System.out.println("+--+--+--+");
        }
    }
    private boolean setplay(int row, int col, String player)
    {
        String mark="X";
        if (player==this.player2)
        {
            mark="O";
        }
        if (check_position(row,col))
        {
            this.board[row][col]=mark;
            this.num_of_plays++;
            this.printboard();
            return true;
        }
        else
        {
            return false;
        }

    }
    private boolean check_position(int row, int col)
    {
        if (this.board[row][col].length()==0)
            return true;
        else
            {
                System.out.println("The position was already marked, please try again");
                return false;
            }
    }
    private boolean check_winner(String current_player)
    {
        if (current_player==this.player1)
            current_player=this.player2;
        else
            current_player=this.player1;
        if (this.num_of_plays>=9)
        {
            System.out.println("It's a Tie!!!");
            return true;
        }

        if (check_win_cols()||check_win_rows()||check_win_cross())
        {
            System.out.println(current_player+" is the Winner!!!");
            return true;
        }
        else
            return false;
    }
    private boolean check_win_rows()
    {
        boolean result=false;
        for (int i=0;i<this.rows;i++)
        {
            if (this.board[i][0]==this.board[i][1] && this.board[i][0]==this.board[i][2]&&this.board[i][0].length()>0)
            {
                result=true;
                break;
            }
        }
        return result;
    }
    private boolean check_win_cols()
    {
        boolean result=false;
        for (int j=0;j<this.cols;j++)
        {
            if (this.board[0][j]==this.board[1][j] && this.board[2][j]==this.board[0][j]&&this.board[0][j].length()>0)
            {
                result=true;
                break;
            }
        }
        return result;
    }
    private boolean check_win_cross()
    {
        boolean result=false;
        if (this.board[0][0] == this.board[1][1] && this.board[2][2] == this.board[1][1] && this.board[0][0].length()>0)
        {
            result=true;
        }
        if (this.board[2][0] == this.board[1][1] && this.board[1][2] == this.board[1][1] && this.board[2][0].length()>0)
        {
            result=true;
        }
        return result;
    }

    private boolean validate_value(int value)
    {
        if (value>=0 && value<=2)
            return true;
        else
            return false;
    }

    public void game_on ()
    {
        Scanner keyboard=new Scanner(System.in);
        String current_player=this.player1;
        int row=0;
        int col=0;
        while (!check_winner(current_player))
        {
            System.out.println(current_player+ " Place your move:");
            System.out.println(current_player+ " Enter the row number Value between 0-2: ");
            try
            {
                row = keyboard.nextInt();
                System.out.println(current_player+ " Enter the col number: Value between 0-2 ");
                col=keyboard.nextInt();
                if ((!validate_value(row))||(!validate_value(col)))
                {
                    System.out.println("Values out of range, try again");
                    continue;
                }
            }
            catch (Exception e)
            {
                System.out.println("Integer is expected, press any key to continue");
                keyboard.nextLine();
                continue;
            }
            if (setplay(row,col,current_player))
            {
                if (current_player==this.player1)
                    current_player=this.player2;
                else
                    current_player=this.player1;
            }

        }
    }

}
