package jalasoft.training;

public class Spot {
    private char value;
    private int posX;
    private int posY;

    public Spot(int newPosX, int newPosY){
        this.posX = newPosX;
        this.posY = newPosY;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
