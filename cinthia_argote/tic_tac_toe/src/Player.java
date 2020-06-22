public class Player {
  String name;
  int attempts;
  char card;

  Player(String name, char card) {
    this.name = name;
    this.card = card;
    attempts = 5;
  }

  public void setAttempts(int attempts) {
    this.attempts = attempts;
  }

  public int getAttempts() {
    return attempts;
  }
}