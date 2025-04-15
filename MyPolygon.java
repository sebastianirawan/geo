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
		int n = Points.size(); //jumlah titik polygon
        if (n < 3) return false; //jika kurang dari 3 -> bukan polygon

        Boolean gotPositive = null;//arah belokan pertama
        for (int i = 0; i < n; i++) {//loop untuk semua titik dalam poligon
            MyPoint p0 = Points.get(i);//titik sekarang
            MyPoint p1 = Points.get((i + 1) % n);//titik setelahnya
            MyPoint p2 = Points.get((i + 2) % n);//titik yang akan dicek arah belok

            double dx1 = p1.x - p0.x;//komponen x dari vektor p0 ke p1
            double dy1 = p1.y - p0.y; //komponen y dari vektor p0 ke p1
            double dx2 = p2.x - p1.x; //komponen x dari vektor p1 ke p2
            double dy2 = p2.y - p1.y; //komponen y dari vektor p1 ke p2

            double zCrossProduct = dx1 * dy2 - dy1 * dx2;//cross product dari kedua vektor

            if (zCrossProduct != 0) { //jika tidak lurus (belok kana atau kiri)
                boolean isPositive = zCrossProduct > 0;//cek apakah belokan ke kiri atau kanan (true = belok kiri, false = belok kanan)
                if (gotPositive == null) {//saat pengecekan pertama kali
                    gotPositive = isPositive;//set arah belokan
                } else if (gotPositive != isPositive) {//jika arah belokan berbeda
                    return false;//kembalikan false, polygon concave
                }
            }
        }
        return true;//kembalikan true setelah semua titik dicek dan tidak ada belokan beda arak
    }

    /**
     * [6b] luas poligon ini
     * @return
     */
    double area() {
		int n = Points.size();//jumlah titik polygon
        if (n < 3) return 0.0;//jika kurang dari 3 -> bukan polygon

        MyPoint p0 = Points.get(0);//titik acuan yang akan dijadikan segitiga untuk semua titik di polygon
        double totalArea = 0.0;//init luas

        for (int i = 1; i < n - 1; i++) {//untuk semua titk polygon kecuali p0
            MyPoint pi = Points.get(i);//ambil 2 titik selanjutnya
            MyPoint pi1 = Points.get(i + 1);

            MyTriangle triangle = new MyTriangle(p0, pi, pi1);//buat segitiga dari titik-titik tersebut
            totalArea += triangle.area();//tambahkan luas segitiga ke luas total (luas polygon = jumlah semua luas segitiga)
        }

        return totalArea;//kembalikan luas total
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
