package com.epam.training.student_Sergei_Bespalov;

class Circle extends Figure {
    Point center;
    double radius;

    public Circle(Point center, double radius) {
        if (radius<=0.0||center==null) {
            throw new IllegalArgumentException();
        }
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

    @Override
    public Point centroid() {
        return center;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if(figure.getClass()==this.getClass()) {
            if (Math.abs(this.getCenter().getX()-((Circle) figure).getCenter().getX())<0.001&&Math.abs(this.getCenter().getY()-((Circle) figure).getCenter().getY())<0.001 ){
                if (Math.abs(this.getRadius()-((Circle) figure).getRadius())<0.001) {
                    return true;
                }
            }
        }
        return false;
    }
}
