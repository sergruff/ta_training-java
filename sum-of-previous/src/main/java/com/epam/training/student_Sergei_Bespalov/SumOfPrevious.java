package com.epam.training.student_Sergei_Bespalov;

import java.util.Arrays;

public class SumOfPrevious {
    public static void main(String[] args) {
        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};
        System.out.println(Arrays.toString(getSumCheckArray(array)));
    }
    public static boolean[] getSumCheckArray(int[] array){
        boolean[] result = new  boolean[array.length];
        for (int i=2;i<array.length;i++) {
            if (array[i]==array[i-1]+array[i-2]) {
                result[i] = true;
            }
        }
        return result;
    }
}
