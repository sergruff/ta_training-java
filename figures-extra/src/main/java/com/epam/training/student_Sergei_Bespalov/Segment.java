package com.epam.training.student_Sergei_Bespalov;

//import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start==null||end==null) {
            throw new IllegalArgumentException();
        }
        if (start.getX()==end.getX()&&start.getY()==end.getY()){
            throw new IllegalArgumentException();
        }
    this.start = start;
    this.end = end;
    }

    double length() {
    return sqrt(pow((this.start.getX()-this.end.getX()),2)+pow(this.start.getY()-this.end.getY(),2));
    }

    Point middle() {
        return new Point((this.start.getX()+this.end.getX())/2, (this.start.getY()+this.end.getY())/2);
    }

    Point intersection(Segment another) {
    double x1 = this.start.getX();
    double x2 = this.end.getX();
    double x3 = another.start.getX();
    double x4 = another.end.getX();
    double y1 = this.start.getY();
    double y2 = this.end.getY();
    double y3 = another.start.getY();
    double y4 = another.end.getY();
    double t=((x1-x3)*(y3-y4)-(y1-y3)*(x3-x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
    double u=((x1-x3)*(y1-y2)-(y1-y3)*(x1-x2))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4));
    if (0<=t&&t<=1&&0<=u&&u<=1) {
        return new Point(x1+t*(x2-x1),y1+t*(y2-y1));
    }
    return null;
    }

}
