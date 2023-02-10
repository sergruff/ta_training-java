package com.epam.training.student_Sergei_Bespalov;

public class Variable implements Expression {
String name;
int value;
    public Variable(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(int value) {
        this.value=value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toExpressionString() {
        return name;
    }
}
