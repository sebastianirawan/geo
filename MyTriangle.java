
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
		double vx1 = b.x - a.x;//komponen x dari vektor a ke b
        double vy1 = b.y - a.y;//komponen y dari vektor a ke b
        double vx2 = c.x - a.x;//komponen x dari vektor a ke c
        double vy2 = c.y - a.y;//komponen y dari vektor a ke c

        double cross = vx1 * vy2 - vy1 * vx2;//luas jajar genjang yaitu cross product dari kedua vektor 

        return Math.abs(cross) / 2.0;//kembalikan luas segitiga (luas jajar genjang dibagi 2)
    }

}
