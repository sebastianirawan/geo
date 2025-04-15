import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyPointSet {
    /**  */
    List<MyPoint> Points;
    MyPoint pivot;

    /**
     * konstruktor
     * @return
     */
    public MyPointSet() {
        this.Points = new ArrayList<MyPoint>();
    }

    /**
     * [8a] masukin titik
     * @param p
     * @return
     */
    boolean addPoint(MyPoint p) {
        return Points.add(p);
    }
    public void sortByPolarAngle() {
        if (Points.size() < 3) return;

        // Cari titik paling kiri bawah
        pivot = Points.get(0);
        for (int i = 1; i < Points.size(); i++) {
            MyPoint p = Points.get(i);
            if (p.y < pivot.y || (p.y == pivot.y && p.x < pivot.x)) {
                pivot = p;
            }
        }

        // sortir menggunakan sudut dan cross product
        Collections.sort(Points, new Comparator<MyPoint>() {
            public int compare(MyPoint a, MyPoint b) {
                //apabila a atau b adalah pivot itu sendiri
                if (a == pivot) return -1;
                if (b == pivot) return 1;

                //komponen x dan y dari vektor a
                double dax = a.x - pivot.x;
                double day = a.y - pivot.y;
                //komponen x dan y dari vektor b
                double dbx = b.x - pivot.x;
                double dby = b.y - pivot.y;

                //cross product vektor a dan b
                double cross = dax * dby - day * dbx;

                if (cross == 0) {
                    // Kalau kolinear, menghitung jarak ke pivot
                    double daDist = dax * dax + day * day;
                    double dbDist = dbx * dbx + dby * dby;
                    return Double.compare(daDist, dbDist);
                }

                return -Double.compare(cross, 0); // cross > 0 -> a sebelum b
            }
        });
    }
    //method untuk print semua point
    public void printPoints() {
        for (MyPoint p : Points) {
            System.out.printf("%.0f %.0f%n", p.x, p.y);
        }
    }

}