package com.epam.training.student_Sergei_Bespalov;

abstract class Figure{

    public abstract double area();

    public abstract String pointsToString();

    public String toString() {
        return this.getClass().getSimpleName() + "[" + pointsToString() + "]";
    }

    public abstract Point leftmostPoint();

    public abstract Point centroid();
    public abstract boolean isTheSame(Figure figure);


}
