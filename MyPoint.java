public class MyPoint {
    /** komen di sini */
    public double x;
    /** komen di sini */
    public double y;

    /**
     * konstruktor
     * @param x
     * @param y
     */
    MyPoint (double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * [1] jarak ke titik laen
     * @param o
     * @return
     */
    double distanceToOtherPoints(MyPoint o) {
        double dx = this.x - o.x;//selisih koordinat x antara point ini dengan point lain
        double dy = this.y - o.y;//selisih koordinat y antara point ini dengan point lain
		double dist = Math.sqrt(dx*dx + dy*dy); //jarak antara point menggunakan rumus euclidean distance
        return dist; //kembalikan jaraknya
    }
    
    /**
     * [2b] jarak ke segmen garis
     * @param l
     * @return
     */
    double distanceToLineSegment(MyLineSegment l) {
		double res = l.distanceToPoint(this); //panggil method distance to point milik line segment
        return res; //kembalikan distancenya
    }
}
