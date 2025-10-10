package shapes;

public class HeightComparator implements java.util.Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        return s1.compareTo(s2);
    }

}
