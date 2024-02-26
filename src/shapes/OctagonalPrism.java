package shapes;

public class OctagonalPrism {
    private double sideLength;
    private double height;

    public OctagonalPrism(double sideLength, double height) {
        this.sideLength = sideLength;
        this.height = height;
    }

    public double getArea() {
        return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
    }

    public double getVolume() {
        return sideLength * sideLength * height;
    }

    public double getHeight() {
        return height;
    }
}
