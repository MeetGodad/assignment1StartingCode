package shapes;

public class Cone extends shapes.Shape {

	private double radius;
	private double height;

	public Cone(double height, double radius) {
		super(height);
		this.height = height;
		this.radius = radius;
	}

	public double getVolume() {
		return (1.0 / 3.0) * Math.PI * radius * radius * height;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public double getBaseArea() {
		return Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
	}

	@Override
	public String toString() {
		return String.format("%s [Height: %.2f, Radius: %.2f, BaseArea: %.2f];", getClass().getSimpleName(), height, radius , getBaseArea() );
	}
}
