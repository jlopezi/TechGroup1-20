package jalasoft.training;

public class Main {

    public static void main(String[] args) {
        Game ticTacToe = new Game();
        while (!ticTacToe.finished) {
            ticTacToe.play();
        };
    }
}
