package com.epam.training.student_Sergei_Bespalov;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);
    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        for (Direction num:Direction.values()){
            if (degrees<0) {
                if (num.degrees==360+degrees%360) {
                    return num;
                }
            }
            if (num.degrees==degrees%360){
                return num;
            }
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        if (degrees<0) degrees=360+degrees;
        for (Direction num:Direction.values()){
            if (Math.abs(num.degrees-degrees%360)<=22){
                return num;
            }
        }
        return null;
    }

    public Direction opposite() {
        return  Direction.ofDegrees((this.degrees+180)%360);
    }

    public int differenceDegreesTo(Direction direction) {
        int diff = Math.abs (this.degrees-direction.degrees);
        if (diff<=180) {
            return diff;
        } else return 360-diff;
    }
}
