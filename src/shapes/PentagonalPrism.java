package shapes;

public class PentagonalPrism extends shapes.Shape {
    private double sideLength;
    private double height;

    public PentagonalPrism(double sideLength, double height) {
    	super(height);
        this.sideLength = sideLength;
        this.height = height;
    }


    public double getVolume() {
        return (1.0 / 6.0) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * sideLength * sideLength * height;
    }

    public double getHeight() {
        return height;
    }

	@Override
	public double getBaseArea() {
		return 0.5 * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * sideLength * sideLength;
	}
	@Ovveride
	public String toString() {
		return String.format("%s [Height: %.2f, SideLength: %.2f, BaseArea: %.2f];", getClass().getSimpleName(), height, sideLength, getBaseArea() );
	}
	
}
