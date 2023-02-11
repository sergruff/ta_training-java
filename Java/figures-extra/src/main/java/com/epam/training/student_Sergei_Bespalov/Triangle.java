package com.epam.training.student_Sergei_Bespalov;

import static java.lang.Math.sqrt;

class Triangle extends Figure {
    Point a;
    Point b;
    Point c;
    Segment ab;
    Segment bc;
    Segment ac;

    public Triangle (Point A, Point B, Point C) {
        this.a = A;
        this.b = B;
        this.c = C;
        this.ab = new Segment(A,B);
        if (ab.length()==0) {throw new IllegalArgumentException();}
        this.bc = new Segment(B,C);
        if (bc.length()==0) {throw new IllegalArgumentException();}
        this.ac = new Segment(A,C);
        if (ac.length()==0) {throw new IllegalArgumentException();}
        if(ab.length()>=bc.length()+ac.length()){
            throw new IllegalArgumentException();
        }
        if( this.area()<0.001) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public double area() {
        double a = ab.length();
        double b = bc.length();
        double c = ac.length();
        double s = (a+b+c)/2; // semiperimetr
        return sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public String toString() {
        return "Triangle[" +
                 a.toString() +
                 b.toString() +
                 c.toString() +
                ']';
    }

    @Override
    public String pointsToString() {
        return a.toString()+ b.toString()+ c.toString();
    }

    @Override
    public Point leftmostPoint() {
        Point result;
        if (a.getX()< b.getX()) {
            result = a;
        } else result = b;
        if (c.getX()<=result.getX()) {
            return c;
        } else return result;
    }

    @Override
    public Point centroid() {
        Point abCentr = ab.middle();
        Segment cCentro = new Segment(abCentr, c);
        Point bcCentr = bc.middle();
        Segment aCentro = new Segment(bcCentr, a);
        return aCentro.intersection(cCentro);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(figure.getClass()==this.getClass()) {
            if (Math.abs(this.getA().getX()-((Triangle) figure).getA().getX())<0.001&&Math.abs(this.getA().getY()-((Triangle) figure).getA().getY())<0.001 ){
                if (Math.abs(this.getB().getX()-((Triangle) figure).getB().getX())<0.001&&Math.abs(this.getB().getY()-((Triangle) figure).getB().getY())<0.001 ) {
                    return Math.abs(this.getC().getX() - ((Triangle) figure).getC().getX()) < 0.001 && Math.abs(this.getC().getY() - ((Triangle) figure).getC().getY()) < 0.001;
                }
            }
        }
        return false;
    }
}
