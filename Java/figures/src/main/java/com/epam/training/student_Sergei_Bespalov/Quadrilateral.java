package com.epam.training.student_Sergei_Bespalov;

class Quadrilateral extends Figure{
    Point a;
    Point b;
    Point c;
    Point d;
    Segment ab;
    Segment bc;
    Segment cd;
    Segment da;
    Segment ac; //Diagonal
    Segment bd; //Diagonal
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        ab = new Segment(a,b);
        bc = new Segment(b,c);
        cd = new Segment(c,d);
        da = new Segment(d,a);
        ac = new Segment(a,c);
        bd = new Segment(b,d);
    }
    @Override
    public double area() {
        double s = (ab.length()+bc.length()+ cd.length()+ da.length())/2; //Semiperimeter
        return Math.sqrt((s-ab.length())*(s- bc.length())*(s-cd.length())*(s- da.length())-(ab.length()*cd.length()+ bc.length()* da.length()+ac.length()* bd.length())*(ab.length()*cd.length()+ bc.length()* da.length()-ac.length()* bd.length())/4);
    }
    @Override
    public String pointsToString() {
        return a.toString()+ b.toString()+ c.toString()+ d.toString();
    }
    @Override
    public String toString() {
        return "Quadrilateral[" +
                a.toString() +
                b.toString() +
                c.toString() +
                d.toString() +
                ']';
    }
    @Override
    public Point leftmostPoint() {
        Point leftPoint =a.getX()<b.getX()?a:b;
        leftPoint = c.getX()<leftPoint.getX()?c:leftPoint;
        return d.getX()<leftPoint.getX()?d:leftPoint;
    }
}
