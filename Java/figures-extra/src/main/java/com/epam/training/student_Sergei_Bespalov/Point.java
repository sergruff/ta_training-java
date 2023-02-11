package com.epam.training.student_Sergei_Bespalov;

class Point {
    private double x;
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString(){
        return "(" + getX() + "," + getY() + ")";
    }

    public boolean isTheSame(Point obj) {
        return Math.abs(this.getX()-obj.getX())<0.001&&Math.abs(this.getY()-obj.getY())<0.001;
    }
}
