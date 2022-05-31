import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) // if both are of same reference or address in memory
            return true;
        // still there is one problem, if we compare the point obj with textBox this
        // will raise an exception of ClassCastException so we need to check whether
        // object we are passing is an instance of Point class
        if (!(obj instanceof Point))
            return false;
        Point point = (Point) obj; // downcasting to Point class
        return this.x == point.x && this.y == point.y;
    }

    // evertime overriding equals() method, we need to override hashCode() method
    @Override
    public int hashCode() {
        // generating hashcode on basis of content of the object
        return Objects.hash(x, y);
    }

}
