package shapes;

public class Cylinder extends shapes.Shape {
    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
    	super(height);
        this.radius = radius;
        this.height = height;
    }


    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

    public double getHeight() {
        return height;
    }

	@Override
	public double getBaseArea() {
		return 2 * Math.PI * radius * (radius + height);
	}
	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, Radius: %.2f, BaseArea: %.2f, Volume: %.2f];", getClass().getSimpleName(), height, radius , getBaseArea(), getVolume() );
	}
}
