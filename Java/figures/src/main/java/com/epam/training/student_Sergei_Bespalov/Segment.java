package com.epam.training.student_Sergei_Bespalov;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;
    public Segment(Point start, Point end) {
        if (start==null||end==null||start.equals(end)) {
            throw new IllegalArgumentException();
        }
    this.start = start;
    this.end = end;
    }
    double length() {
    return sqrt(pow((this.start.getX()-this.end.getX()),2)+pow(this.start.getY()-this.end.getY(),2));
    }
}
