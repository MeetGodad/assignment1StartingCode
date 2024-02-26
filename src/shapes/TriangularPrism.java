package shapes;

public class TriangularPrism {
    private double sideLength;
    private double height;

    public TriangularPrism(double sideLength, double height) {
        this.sideLength = sideLength;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * sideLength * height;
    }

    public double getVolume() {
        return getArea() * height;
    }
}
