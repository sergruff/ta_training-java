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
        Point M = ac.intersection(bd);
        new Triangle(this.a,M, this.b);
        new Triangle(this.b,M, this.c);
        new Triangle(this.c,M, this.d);
        new Triangle(this.d,M, this.a);
        if (this.area()<0.001) {
            throw new IllegalArgumentException();
        }
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
        Point result;
        if (a.getX()< b.getX()) {
            result = a;
        } else result = b;
        if (c.getX()<=result.getX()) {
            result = c;
        }
        if (d.getX()<result.getX()){
            result = d;
        }
        return result;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    @Override
    public Point centroid() {
        Point Ga = new Triangle(this.getB(),this.getC(),this.getD()).centroid();
        Point Gb = new Triangle(this.getA(),this.getC(),this.getD()).centroid();
        Point Gc = new Triangle(this.getA(),this.getB(),this.getD()).centroid();
        Point Gd = new Triangle(this.getA(),this.getB(),this.getC()).centroid();
        Segment GaGc = new Segment(Ga,Gc);
        Segment GbGd = new Segment(Gb,Gd);
        return GaGc.intersection(GbGd) ;
    }
    public boolean havePoint (Point point){
        return this.getA().isTheSame(point) || this.getB().isTheSame(point) || this.getC().isTheSame(point) || this.getD().isTheSame(point);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(figure.getClass()==this.getClass()) {
            if (this.havePoint(((Quadrilateral) figure).getA())){
                if (this.havePoint(((Quadrilateral) figure).getB())) {
                    if (this.havePoint(((Quadrilateral) figure).getC())) {
                        return this.havePoint(((Quadrilateral) figure).getD());
                    }
                }
            }
        }
        return false;
    }
}
