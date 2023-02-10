package com.epam.training.student_Sergei_Bespalov;

import static java.lang.Math.sqrt;

class Triangle {
    Segment ab;
    Segment bc;
    Segment ac;
    Point a;
    Point b;
    Point c;
    public Triangle(Point a, Point b, Point c) {
       this.a = a;
        this.b = b;
        this.c = c;
        this.ab = new Segment(a,b);
        this.bc = new Segment(b,c);
        this.ac = new Segment(a,c);
        if((ab.length()>=bc.length()+ac.length())||(bc.length()>=ab.length()+ac.length())||(ac.length()>=ab.length()+bc.length())) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
         double a = ab.length();
         double b = bc.length();
         double c = ac.length();
         double s = (a+b+c)/2; // semiperimetr
        return sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public Point centroid(){
        return new Segment(bc.middle(), a).intersection(new Segment(ab.middle(), c));
    }

}
