package shapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape> {
    public static final Comparator<Shape> COMPARE_BY_HEIGHT = new ShapeComparator(ShapeComparator::compareByHeight);
    public static final Comparator<Shape> COMPARE_BY_BASE_AREA = new ShapeComparator(ShapeComparator::compareByBaseArea);
    public static final Comparator<Shape> COMPARE_BY_VOLUME = new ShapeComparator(ShapeComparator::compareByVolume);

    private Comparator<Shape> comparator;

    private ShapeComparator(Comparator<Shape> comparator) {
        this.comparator = comparator;
    }

    @Override
    public int compare(Shape s1, Shape s2) {
        return comparator.compare(s1, s2);
    }

    private static int compareByHeight(Shape s1, Shape s2) {
        return Double.compare(s1.getHeight(), s2.getHeight());
    }

    private static int compareByBaseArea(Shape s1, Shape s2) {
        return Double.compare(s1.getBaseArea(), s2.getBaseArea());
    }

    private static int compareByVolume(Shape s1, Shape s2) {
        return Double.compare(s1.getVolume(), s2.getVolume());
    }
}
