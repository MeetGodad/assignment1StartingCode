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

	
}
