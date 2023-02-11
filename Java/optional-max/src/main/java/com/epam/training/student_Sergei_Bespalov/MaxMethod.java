package com.epam.training.student_Sergei_Bespalov;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
        if (values!=null&&values.length>0) {
        int max = values[0];
        for (int value : values) {
            if (value >max) {max= value;}
        }
        return OptionalInt.of(max);
        }
        else return OptionalInt.empty();
    }
}
