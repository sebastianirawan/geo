
public class MyTriangle {
    /**  */
    MyPoint a,b,c;

    /**
     * konstruktor
     * @return
     */
    public MyTriangle(MyPoint a, MyPoint b, MyPoint c) {
        this.a = a;
		this.b = b;
		this.c = c;
    }

    /**
     * 
     * @param 
     * @return
     */
    double area() {
		double vx1 = b.x - a.x;
        double vy1 = b.y - a.y;
        double vx2 = c.x - a.x;
        double vy2 = c.y - a.y;

        double cross = vx1 * vy2 - vy1 * vx2;

        return Math.abs(cross) / 2.0;
    }

}
