package shapes;

public class PentagonalPrism {
    private double sideLength;
    private double height;

    public PentagonalPrism(double sideLength, double height) {
        this.sideLength = sideLength;
        this.height = height;
    }

    public double getArea() {
        return 0.5 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * sideLength * sideLength;
    }

    public double getVolume() {
        return (1.0 / 6.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * sideLength * sideLength * height;
    }

    public double getHeight() {
        return height;
    }
}
