import java.util.Scanner;

public class TicTacToeBoard {
    private char[][] board;
    private boolean isGameOver = false;

    public TicTacToeBoard()
    {
        board = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        System.out.println("====================");
        System.out.println("===  TIC TAC TOE ===");
        System.out.println("====================");

       printBoard();
    }

    public void runGame(){
        int counter = 1;
        while (gameActive() && counter < 10)
        {
            if (counter % 2 == 0) {
                askPositionPlayer('O');
            }
            else {
                askPositionPlayer('X');
            }

            counter++;
        }

        if (counter == 10)
        {
            System.out.println("Tie!");
        }
    }

    private void printBoard()
    {
        for (char[] row: board) {
            for (char c: row)
            {
                System.out.print((c));
            }
            System.out.println();
        }
    }

    private void askPositionPlayer(char playerOption)
    {
        Scanner scanner = new Scanner(System.in);
        int position;

        do {
            System.out.printf("Player %s - Please enter your placement between 1 to 9:", playerOption);
            position = scanner.nextInt();

        } while (!isValidPosition(position));

        setPosition(position, playerOption);
        printBoard();
        checkWinner();
    }

    private boolean isValidPosition(int position)
    {
        if(position >= 1 && position <= 9 && isEmpty(position))
            return  true;
        return false;
    }

    private boolean isEmpty(int position)
    {
        switch (position)
        {
            case 1:
                if (board[0][0] == ' '){
                    return true;
                }
                break;
            case 2:
                if (board[0][2] == ' '){
                    return true;
                }
                break;
            case 3:
                if (board[0][4] == ' '){
                    return true;
                }
                break;
            case 4:
                if (board[2][0] == ' '){
                    return true;
                }
                break;
            case 5:
                if (board[2][2] == ' '){
                    return true;
                }
                break;
            case 6:
                if (board[2][4] == ' '){
                    return true;
                }
                break;
            case 7:
                if (board[4][0] == ' '){
                    return true;
                }
                break;
            case 8:
                if (board[4][2] == ' '){
                    return true;
                }
                break;
            case 9:
                if (board[4][4] == ' '){
                    return true;
                }
                break;
            default:
                break;
        }

        System.out.println("That position is taken");
        return false;
    }

    private void checkWinner(){
        for(int i = 0; i < 5; i+=2){
            if (board[i][0] == board[i][2] && board[i][2] == board[i][4] && board[i][0] != ' ')
            {
                System.out.printf("The winner is %s", board[i][0]);
                isGameOver = true;
            }
        }

        for(int i = 0; i < 5; i+=2){
            if (board[0][i] == board[2][i] && board[2][i] == board[4][i] && board[0][i] != ' ')
            {
                System.out.printf("The winner is %s", board[0][i]);
                isGameOver = true;
            }
        }

        if (board[0][0] == board[2][2] && board[2][2] == board[4][4] && board[0][0] != ' ')
        {
            System.out.printf("The winner is %s", board[0][0]);
            isGameOver = true;
        }

        if (board[4][0] == board[2][2] && board[2][2] == board[0][4] && board[4][0] != ' ')
        {
            System.out.printf("The winner is %s", board[4][0]);
            isGameOver = true;
        }
    }

    private void setPosition(int position, char option)
    {
        switch (position)
        {
            case 1:
                board[0][0] = option;
                break;
            case 2:
                board[0][2] = option;
                break;
            case 3:
                board[0][4] = option;
                break;
            case 4:
                board[2][0] = option;
                break;
            case 5:
                board[2][2] = option;
                break;
            case 6:
                board[2][4] = option;
                break;
            case 7:
                board[4][0] = option;
                break;
            case 8:
                board[4][2] = option;
                break;
            case 9:
                board[4][4] = option;
                break;
            default:
                break;
        }
    }

    private boolean gameActive()
    {
        return !isGameOver;
    }
}
