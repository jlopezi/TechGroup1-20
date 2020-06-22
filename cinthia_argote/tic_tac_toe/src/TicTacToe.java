import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
  private Player player1;
  private Player player2;
  private boolean winner;
  Board board;

  TicTacToe() {
    player1 = new Player("First Player", 'X');
    player2 = new Player("Second Player", 'O');
    board = new Board();
    winner = false;
  }

  private boolean validateValue(int value) {
    if(value > 9 || value < 0) {
      System.out.println("Invalid value, re enter slot number:");
      return false;
    }
    return true;
  }

  public Player playerMove() {
    if(player1.attempts == player2.attempts) {
      return player1;
    } else {
      return player2;
    }
  }

  public void playGame() {
    System.out.println("X will play first. Enter a slot number to place X in:");
    System.out.println("O will play second.");
    board.printBoard();
    Scanner input = new Scanner(System.in);
    Player currentPlayer;
    while(!board.isCompleteBoard()){
      try {
        int slotNumber = input.nextInt();
        char value = Integer.toString(slotNumber).charAt(0);
        if(!board.isMarked(value)) {
          if(validateValue(slotNumber)) {
            currentPlayer = playerMove();
            board.markBoard(value, currentPlayer.card);
            currentPlayer.setAttempts(currentPlayer.attempts-1);
            board.printBoard();
          }
        } else {
          System.out.println("Slot already taken");
        }
        winner = board.isWinner();
        if(winner) {
          System.out.println("Congratulations! - you're the winner");
          input.close();
          break;
        }
      } catch (InputMismatchException e){
        String badInput = input.next();
        System.out.println("Please, just enter the slot numbers" + badInput);
        continue;
      }
    }

    if(!winner && board.isCompleteBoard()) {
      System.out.println("It's a tie !!");
    }
  }
}