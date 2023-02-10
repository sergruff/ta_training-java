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
        this.bc = new Segment(B,C);
        this.ac = new Segment(A,C);
        if((ab.length()>=bc.length()+ac.length())){
            throw new IllegalArgumentException();
        }
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
        Point leftPoint=a.getX()<b.getX()?a:b;
        return c.getX()<leftPoint.getX()?c:leftPoint;
    }
}
