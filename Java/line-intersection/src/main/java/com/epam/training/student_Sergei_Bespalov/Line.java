package com.epam.training.student_Sergei_Bespalov;

public class Line {
    int k;
    int b;
    public Line(int k, int b) {
    this.k = k;
    this.b = b;
    }
    public Point intersection(Line other) {
        if (this.k == other.k) {return null;}
        return new Point((other.b-this.b)/(this.k-other.k),(this.b*other.k - other.b*this.k)/(other.k - this.k));
    }

}
