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

  public void playGame() {
    System.out.println(" X will play first. Enter a slot number to place X in:");
    board.printBoard();
    Scanner scanner = new Scanner(System.in);
    try {
      while(!board.isCompleteBoard()) {
        int slotNumber = scanner.nextInt();
        char value = Integer.toString(slotNumber).charAt(0);
        if(!board.isMarked(value)) {
          if(validateValue(slotNumber)) {
            if(player1.attempts == player2.attempts) {
              board.markBoard(value, player1.card);
              player1.setAttempts(player1.attempts-1);
            } else {
              board.markBoard(value, player2.card);
              player2.setAttempts(player2.attempts-1);
            }
              board.printBoard();
          }
        } else {
          System.out.println("Slot already taken");
        }
        winner = board.isWinner();
        if(winner) {
          System.out.println("Congratulations! - you're the winner");
          scanner.close();
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Please, just enter the slot numbers");
    }
  }
}