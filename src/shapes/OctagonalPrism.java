package shapes;

public class OctagonalPrism extends shapes.Shape {
    private double sideLength;
    private double height;

    public OctagonalPrism(double sideLength, double height) {
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
		return 2 * (1 + Math.sqrt(2)) * sideLength * sideLength;
    }
	
	public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f];", getClass().getSimpleName(), height, sideLength , getBaseArea() );
	}
	
}
