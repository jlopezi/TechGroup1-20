import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
  private Player player;
  
  @Before
  public void setUp(){
    player = new Player("name",'x');
  }
  
  @Test
  public void setAttempts(){
    player.setAttempts(2);
    int attempts = player.getAttempts();
    assertEquals(2, attempts);
  }
}