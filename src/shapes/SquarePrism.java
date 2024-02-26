package shapes;

public class SquarePrism {
    private double sideLength;
    private double height;

    public SquarePrism(double sideLength, double height) {
        this.sideLength = sideLength;
        this.height = height;
    }

    public double getArea() {
        return 4 * sideLength * sideLength;
    }

    public double getVolume() {
        return sideLength * sideLength * height;
    }

    public double getHeight() {
        return height;
    }
}