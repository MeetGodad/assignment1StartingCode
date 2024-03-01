package shapes;

public class TriangularPrism extends shapes.Shape {
    private double sideLength;
    private double height;

    public TriangularPrism(double sideLength, double height) {
    	super(height);
        this.sideLength = sideLength;
        this.height = height;
    }

	public double getBaseArea() {
		return 0.5 * sideLength * height;
	}
    
    public double getVolume() {
        return getBaseArea() * height;
    }
    @Override
    public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, sideLength, getBaseArea(), getVolume() );
	}
	
}
