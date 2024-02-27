package shapes;

public class SquarePrism extends shapes.Shape {
    private double sideLength;
    private double height;

    public SquarePrism(double sideLength, double height) {
    	super(height);
        this.sideLength = sideLength;
        this.height = height;
    }

    public double getVolume() {
        return sideLength * sideLength * height;
    }

    public double getHeight() {
        return height;
    }

	@Override
	public double getBaseArea() {
		return 4 * sideLength * sideLength;
	}
}