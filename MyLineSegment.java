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
    double distanceToPoint(MyPoint p) { //https://stackoverflow.com/questions/849211/shortest-distance-between-a-point-and-a-line-segment
		double x = p.x, y = p.y;
        double x1 = this.start.x, y1 = this.start.y;
        double x2 = this.end.x, y2 = this.end.y;

        double A = x - x1;
        double B = y - y1;
        double C = x2 - x1;
        double D = y2 - y1;

        double dot = A * C + B * D;
        double len_sq = C * C + D * D;
        double param = -1;
        if (len_sq != 0) {
            param = dot / len_sq;
        }

        double xx, yy;

        if (param < 0) {
            xx = x1;
            yy = y1;
        } else if (param > 1) {
            xx = x2;
            yy = y2;
        } else {
            xx = x1 + param * C;
            yy = y1 + param * D;
        }

        double dx = x - xx;
        double dy = y - yy;

        return Math.sqrt(dx * dx + dy * dy);
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
    boolean isIntersect(MyLineSegment other) {//https://www.naukri.com/code360/library/check-if-two-line-segments-intersect
		MyPoint a1 = this.start;
        MyPoint b1 = this.end;
        MyPoint a2 = other.start;
        MyPoint b2 = other.end;

        double d1 = this.leftTurnToPoint(a2);
        double d2 = this.leftTurnToPoint(b2);
        double d3 = other.leftTurnToPoint(a1);
        double d4 = other.leftTurnToPoint(b1);

        if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) &&
            ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
            return true;
        }

        if ((d1 == 0 && onSegment(a1, b1, a2)) ||
            (d2 == 0 && onSegment(a1, b1, b2)) ||
            (d3 == 0 && onSegment(a2, b2, a1)) ||
            (d4 == 0 && onSegment(a2, b2, b1))) {
            return true;
        }

        return false;
    }

    boolean onSegment(MyPoint p, MyPoint q, MyPoint r) {
        return r.x <= Math.max(p.x, q.x) && r.x >= Math.min(p.x, q.x) && r.y <= Math.max(p.y, q.y) && r.y >= Math.min(p.y, q.y);
    }
}