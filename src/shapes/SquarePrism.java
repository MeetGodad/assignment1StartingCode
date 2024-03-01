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
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, sideLength, getBaseArea(), getVolume() );
	}
}