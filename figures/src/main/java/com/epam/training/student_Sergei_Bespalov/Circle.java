package com.epam.training.student_Sergei_Bespalov;

class Circle extends Figure {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI*(radius*radius);
    }
    @Override
    public String pointsToString() {
        return center.toString();
    }
    @Override
    public String toString() {
        return "Circle["+center.toString()+radius+"]";
    }
    @Override
    public Point leftmostPoint() {
        return new Point((center.getX()-radius),center.getY());
    }
}
