public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point createPoint(String coordinate) {
        String[] data = coordinate.split(":");
        try {
            int coordX = Integer.parseInt(data[0]);
            int coordY = Integer.parseInt(data[1]);
            return new Point(coordX, coordY);
        } catch (Exception e) {
            return null;
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
