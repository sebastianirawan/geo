import java.util.ArrayList;
import java.util.List;

public class MyPolygon {
    /**  */
    List<MyPoint> Points;

    /**
     * konstruktor
     * @return
     */
    public MyPolygon() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [5a,6a,7a] masukin titik
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        return Points.add(p);
    }

    /**
     * [5b] konveks ato bukan
     * @return
     */
    boolean isConvex() { //https://stackoverflow.com/a/1881201
		int n = Points.size();
        if (n < 3) return false;

        Boolean gotPositive = null;
        for (int i = 0; i < n; i++) {
            MyPoint p0 = Points.get(i);
            MyPoint p1 = Points.get((i + 1) % n);
            MyPoint p2 = Points.get((i + 2) % n);

            double dx1 = p1.x - p0.x;
            double dy1 = p1.y - p0.y;
            double dx2 = p2.x - p1.x;
            double dy2 = p2.y - p1.y;

            double zCrossProduct = dx1 * dy2 - dy1 * dx2;

            if (zCrossProduct != 0) {
                boolean isPositive = zCrossProduct > 0;
                if (gotPositive == null) {
                    gotPositive = isPositive;
                } else if (gotPositive != isPositive) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * [6b] luas poligon ini
     * @return
     */
    double area() {
		double area = 0.0;
		
        return area;
    }

    /**
     * [7b] titik p di dalem ato luar,
     * jika berimpitan dengan titik atau segmen, di dalam 
     * @param p
     * @return
     */
    boolean isPointInside(MyPoint p) {
		boolean inside = true;
		
        return inside;
    }

}
