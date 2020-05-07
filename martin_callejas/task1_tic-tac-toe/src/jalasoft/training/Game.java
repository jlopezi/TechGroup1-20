package jalasoft.training;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private int length;
    private int rows;
    private int cols;
    private Spot[][] spots;
    private HashMap<Integer, Spot> spotsMap;
    private ArrayList<Integer> availableSpots;
    private ArrayList<Character> playersMark;
    private boolean currentPlayer;

    public boolean finished;

    public Game(){
        playersMark = new ArrayList<Character>();
        playersMark.add('X');
        playersMark.add('O');

        length = 3;
        rows = length;
        cols = length;
        spots = new Spot[rows][cols];

        int cursor = 1;
        spotsMap = new HashMap<Integer, Spot>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                spots[i][j] = new Spot(i, j);
                spotsMap.put(cursor, spots[i][j]);
                cursor++;
            }
        }
        render();
    }

    public void play(){
        char currentPlayerMark;
        String currentPlayerName;
        if (!currentPlayer){
            currentPlayerMark = playersMark.get(0);
            currentPlayerName = "1";
        }
        else{
            currentPlayerMark = playersMark.get(1);
            currentPlayerName = "2";
        }

        Scanner scanner = new Scanner(System.in);
        int position = -1;
        do {
            System.out.println("Player " + currentPlayerName + " (" + currentPlayerMark + ") turn!");
            String strAvailableSpots = "[";
            for (int availableSpot : availableSpots){
                strAvailableSpots += availableSpot + ",";
            }
            strAvailableSpots += "]";
            System.out.println("Available positions: " + strAvailableSpots);

            String strPosition;
            System.out.print("Position? ");
            strPosition = scanner.next();
            position = tryParse(strPosition);

        } while (!availableSpots.contains(position));

        setValue(position, currentPlayerMark);
        render();

        boolean winnerExists = checkWinner();
        if (winnerExists){
            System.out.println("Player " + currentPlayerName + " (" + currentPlayerMark + ") wins! :)");
            finished = true;
        }
        if (availableSpots.size() == 0){
            System.out.println("Ends in draw :(");
            finished = true;
        }
        currentPlayer = !currentPlayer;
    }

    private void render(){
        availableSpots = new ArrayList<>();
        for (int i = 1; i <= Math.pow(length, 2); i++) {
            Spot currentSpot = spotsMap.get(i);
            if (currentSpot.getValue() != '\0')
                System.out.print(currentSpot.getValue());
            else{
                System.out.print(i);
                availableSpots.add(i);
            }

            if ((i % length) != 0)
                System.out.print(" | ");
            else System.out.println();
        }
    }

    private void setValue(int position, char value) {
        spotsMap.get(position).setValue(value);
    }

    private boolean checkWinner(){
        ArrayList<Spot> currentRow = new ArrayList<Spot>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (spots[i][j].getValue() != '\0')
                    currentRow.add(spots[i][j]);
            }
            if (currentRow.size() == length)
                if (allItemsAreEqual(currentRow))
                    return true;
            currentRow = new ArrayList<Spot>();
        }

        ArrayList<Spot> currentCol = new ArrayList<Spot>();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (spots[i][j].getValue() != '\0')
                    currentCol.add(spots[i][j]);
            }
            if (currentCol.size() == length)
                if (allItemsAreEqual(currentCol))
                    return true;
            currentCol = new ArrayList<Spot>();
        }

        ArrayList<Spot> diagonal = new ArrayList<Spot>();
        for (int i = 0; i < length; i++) {
            if ((spots[i][i].getValue() != '\0'))
                diagonal.add(spots[i][i]);
        }
        if (diagonal.size() == length)
            if (allItemsAreEqual(diagonal))
                return true;

        ArrayList<Spot> antiDiagonal = new ArrayList<Spot>();
        int i = 0;
        int j = length - 1;
        while (i < length) {
            if (spots[i][j].getValue() != '\0')
                antiDiagonal.add(spots[i][j]);
            i++;
            j--;
        }
        if (antiDiagonal.size() == length)
            if (allItemsAreEqual(antiDiagonal))
                return true;

        return false;
    }

    private boolean allItemsAreEqual(ArrayList<Spot> line){
        for (Spot spot : line) {
            if (spot.getValue() != line.get(0).getValue()) return false;
        }
        return true;
    }

    public int tryParse(String value){
        int defaultValue = - 1;
        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
