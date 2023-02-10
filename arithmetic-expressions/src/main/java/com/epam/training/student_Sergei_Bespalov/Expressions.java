package com.epam.training.student_Sergei_Bespalov;

public class Expressions {

    public static Variable var(String name, int value) {
        return new Variable(name,value);
    }

    public static Expression val(int value) {
        String name;
        if (value<0) {name = "("+value+")";}
        else {name = String.valueOf(value);}
        return new Variable(name,value);
    }

    public static Expression sum(Expression... members){

        return new Expression() {

            @Override
            public int evaluate() {
                int value = 0;
                for (int i = 0; i< members.length; i++){
                    value+=members[i].evaluate();
                }
                return value;
            }

            @Override
            public String toExpressionString() {
                String name = "(";
                for (int i = 0; i< members.length; i++){
                    name+=members[i].toExpressionString();
                    if(i<members.length-1) {
                        name+=" + ";
                    }
                }
                name+=")";
                return name;
            }
        };
    }

    public static Expression product(Expression... members){
        return new Expression() {

            @Override
            public int evaluate() {
                int value = 0;
                for (int i = 0; i< members.length; i++){
                    if (i==0) {
                        value=members[i].evaluate();
                    } else
                    value*=members[i].evaluate();
                }
                return value;
            }

            @Override
            public String toExpressionString() {
                String name = "(";
                for (int i = 0; i< members.length; i++){
                    name+=members[i].toExpressionString();
                    if(i<members.length-1) {
                        name+=" * ";
                    }
                }
                name+=")";
                return name;
            }
        };
    }


    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression() {

            @Override
            public int evaluate() {
                return minuend.evaluate()-subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+minuend.toExpressionString()+" - " +subtrahend.toExpressionString() + ")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        return new Expression() {

            @Override
            public int evaluate() {
                return dividend.evaluate()/divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "("+dividend.toExpressionString()+" / " +divisor.toExpressionString() + ")";
            }
        };
    }

}
