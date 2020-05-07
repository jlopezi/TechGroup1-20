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

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
