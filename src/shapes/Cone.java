package shapes;

public abstract class Cone extends shapes.Shape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getArea() {
        return Math.PI * radius * (radius + Math.sqrt(height * height + radius * radius));
    }

    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    public double getHeight() {
        return height;
    }
}

