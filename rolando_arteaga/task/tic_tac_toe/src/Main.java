public class Main {
    public static void main(String[] arg) {
        try {
            new Game(new Player("×", ConsoleColors.BLUE),
                    new Player("o", ConsoleColors.RED));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}