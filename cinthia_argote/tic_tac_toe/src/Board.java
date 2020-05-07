public class Board {
  private char[][] board;

  Board() {
    board =  new char[3][3];
    initializeBoard();
  }

  private void initializeBoard() {
    int content = 1;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        board[i][j] = Integer.toString(content).charAt(0);
        content = content+1;
      }
    }
  }
  
  public void printBoard() {
    System.out.println("-------------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j] + " | ");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }

  public boolean isCompleteBoard() {
    boolean isComplete = true;
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(Character.isDigit(board[i][j])) {
          isComplete = false;
        }
      }
    }
    return isComplete;
  }

  private boolean checkColumns() {
    for (int i = 0; i < 3; i++) {
      if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
        return true;
      }
    }
    return false;
  }

  private boolean checkDiagonals() {
    return (board[0][0]==board[1][1] && board[0][0] == board[2][2] || board[0][2] == board[1][1] && board[0][2] == board[2][0]);
  }

  private boolean checkRows() {
    for (int i = 0; i < 3; i++) {
      if (board[i][0]==board[i][1] && board[i][0]==board[i][2]) {
          return true;
      }
    }
    return false;  
  }

  public boolean isWinner() {
    return (checkDiagonals() || checkRows() || checkColumns());
  }

  public void markBoard(char number, char value) {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(board[i][j] == number) {
          board[i][j] = value;
        }
      }
    }
  }

  public boolean isMarked(char number) {
    boolean marked = true;
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(board[i][j] == number) {
          marked = false;
        }
      }
    }
    return marked;
  }
}