package shapes;

public class Pyramid extends shapes.Shape {
    private double baseSideLength;
    private double height;

    public Pyramid( double height, double baseSideLength) {
    	super(height);
        this.baseSideLength = baseSideLength;
        this.height = height;
    }
    

    public double getVolume() {
        return (1.0 / 3.0) * Math.sqrt(2) * baseSideLength * baseSideLength * height;
    }

    public double getHeight() {
        return height;
    }

	public double getBaseArea() {
		 return Math.sqrt(2) * baseSideLength * baseSideLength;
	}
}