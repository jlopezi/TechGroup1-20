import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        System.out.println("Tic Tac Toe Game");
        try {
            do {
                game.printTable();
                int row;
                int col;
                do {
                    System.out.println("Player " + game.getCurrentPlayer() + ":");
                    System.out.println("Enter an empty row number in range 1-3");
                    row = scan.nextInt() - 1;
                    System.out.println("Enter an empty column number in range 1-3");
                    col = scan.nextInt() - 1;
                    if(!game.isValid(row, col)){
                        System.out.println("Please enter valid numbers in range 1-3 and look for empty rows/cols");
                    }
                }
                while (!game.putMark(row, col));
                game.changePlayer();
            }
            while (!game.isWinner() && !game.isTableFull());

            if (game.isTableFull() && !game.isWinner()){
                System.out.println("The players tied!");
            }
            else{
                game.printTable();
                game.changePlayer();
                System.out.println("Player " + game.getCurrentPlayer() + " is the winner!");
            }
        } catch(Exception exception){
            System.out.println("Error occurred: " + exception.toString());
        }
    }
}
