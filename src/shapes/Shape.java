package shapes;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    private double height;

    public Shape(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public abstract double getBaseArea();

    public abstract double getVolume();

    @Override
    public int compareTo(Shape other) {
        return Double.compare(this.getHeight(), other.getHeight());
    }

    public static Comparator<Shape> getComparator(String comparisonType) {
        switch (comparisonType) {
            case "height":
                return Comparator.comparing(Shape::getHeight);
            case "baseArea":
                return Comparator.comparing(Shape::getBaseArea);
            case "volume":
                return Comparator.comparing(Shape::getVolume);
            default:
                throw new IllegalArgumentException("Invalid comparison type");
        }
    }
}
