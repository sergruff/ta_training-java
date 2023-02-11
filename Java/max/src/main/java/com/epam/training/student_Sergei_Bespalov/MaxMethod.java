package com.epam.training.student_Sergei_Bespalov;

public class MaxMethod {
    public static int max(int[] values) {
        int maxValue = values[0];
        for (int number:values) {
            if (maxValue < number) {
                maxValue = number;
            }
        }
        return maxValue;
    }
}
