public class MyLineSegment {
    /** ``vektor'' dari start ke end */
    MyPoint start;
    /** komen di sini */
    MyPoint end;
    double len;

    /**
     * konstruktor
     * @param start
     * @param end
     */
    MyLineSegment(MyPoint start, MyPoint end) {
        this.start = start;
        this.end = end;
        this.len = start.distanceToOtherPoints(end);
    }

    /**
     * [2a] jarak ke titik
     * @param p
     * @return
     */
    double distanceToPoint(MyPoint p) {
        double abx = this.end.x - this.start.x;//vektor ab (titik awal line segment ke titk akhir line segment)
        double aby = this.end.y - this.start.y;
       
        double apx = p.x - this.start.x; //vektor ap (titik awal line segment ke titk p)
        double apy = p.y - this.start.y;
      
        double bax = this.start.x - this.end.x; //vektor ba (titik akhir line segment ke titk awal line segment)
        double bay = this.start.y - this.end.y;
       
        double bpx = p.x - this.end.x; //vektor bp titik akhir line segment ke titk p)
        double bpy = p.y - this.end.y;
    
        double abDotAp = abx * apx + aby * apy;//dot product ab dengan ap
        double baDotBp = bax * bpx + bay * bpy;//dot product ba dengan bp
    
        if (abDotAp < 0) {//jika dot product ab denagn ap negatif, titik p paling dekat ke a
            return this.start.distanceToOtherPoints(p);//kembalikan jarak titk awal line segment ke p
        }
        else if (baDotBp < 0) {//jika dot product ba dengan bp negatif, titik p paling dekat ke b
            return this.end.distanceToOtherPoints(p);//kembalikan jarak titk akhir line segment ke p
        } else { //jika titik p di antara a dan b, hitung jarak tegak lurus  dari p ke line segment
            double cross = Math.abs(abx * apy - aby * apx);//cross product vektor ab dengan ap untuk mendapatkan luas jajar genjang
            double base = Math.sqrt(abx * abx + aby * aby);//panjang vektor line segment (alas jajar genjang)
            return cross / base;//kembalikan jarak, yaitu luas jajar genjang dibagi alas
        }
    }

    /**
     * [3] dari start ke end ke target belok kiri, kanan, atao lurus
     * @param target
     * @return
     */
    double leftTurnToPoint(MyPoint target) {
		double res = 0.0;
		res = CG.ccw(this.start, this.end, target);
        return res; //return 0 jika lurus, plus/minus jika belok kanan/kiri,  
    }
    
    /**
     * [4] motong segmen laen?
     * @param other
     * @return
     */
    boolean isIntersect(MyLineSegment other) {
        MyPoint a1 = this.start; //titik awal line segmen pertama
        MyPoint b1 = this.end;//titik akhir line segmen pertama
        MyPoint a2 = other.start; //titik awal line segmen kedua
        MyPoint b2 = other.end; //titik akhir line segmen kedua
    
        double d1 = this.leftTurnToPoint(a2);//arah belokan dari line segmen pertama ke titik awal line segmen kedua
        double d2 = this.leftTurnToPoint(b2);//arah belokan dari line segmen pertama ke titik akhir line segmen kedua
        double d3 = other.leftTurnToPoint(a1);//arah belokan dari line segmen kedua ke titik awal line segmen pertama
        double d4 = other.leftTurnToPoint(b1);//arah belokan dari line segmen kedua ke titik akhir line segmen pertama
    
        if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) && ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) { //jika titik-titik line segment pertama berada di kanan dan kiri line segment kedua, dan sebaliknya)
            return true;//line segment saling intersect
        }
    
        return false;//jika tidak, return false
    }
}