import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
  private Board board;

  @Before
  public void setUp(){
    board = new Board();
  }

  @Test
  public void isCompleteBoard(){
    board.markBoard('1', 'x');
    board.markBoard('2', 'o');
    board.markBoard('3', 'x');
    board.markBoard('4', 'x');
    board.markBoard('5', 'o');
    board.markBoard('6', 'x');
    board.markBoard('7', 'x');
    board.markBoard('8', 'o');
    board.markBoard('9', 'x');
    boolean completeBoard = board.isCompleteBoard();
    assertTrue(completeBoard);
  }

  @Test
  public void isNoCompleteBoard(){
    boolean noCompleteBoard = board.isCompleteBoard();
    assertFalse(noCompleteBoard);
  }


  @Test
  public void isWinnerByColumns1(){
    board.markBoard('1', 'x');
    board.markBoard('4', 'x');
    board.markBoard('7', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isWinnerByColumns2(){
    board.markBoard('2', 'x');
    board.markBoard('5', 'x');
    board.markBoard('8', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isWinnerByColumns3(){
    board.markBoard('3', 'x');
    board.markBoard('6', 'x');
    board.markBoard('9', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isWinnerByDiagonals1(){
    board.markBoard('1', 'x');
    board.markBoard('5', 'x');
    board.markBoard('9', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isWinnerByDiagonals2(){
    board.markBoard('3', 'x');
    board.markBoard('5', 'x');
    board.markBoard('7', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isWinnerByRows1(){
    board.markBoard('1', 'x');
    board.markBoard('2', 'x');
    board.markBoard('3', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isWinnerByRows2(){
    board.markBoard('4', 'x');
    board.markBoard('5', 'x');
    board.markBoard('6', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isWinnerByRows3(){
    board.markBoard('7', 'x');
    board.markBoard('8', 'x');
    board.markBoard('9', 'x');
    boolean isWinner = board.isWinner();
    assertTrue(isWinner);
  }

  @Test
  public void isMarked(){
    board.markBoard('4', 'x');
    boolean marked = board.isMarked('4');
    assertTrue(marked);
    boolean noMarked = board.isMarked('5');
    assertFalse(noMarked);
  }
}