package com.epam.training.student_Sergei_Bespalov;

public class SumOfEvenNumbers {

    public static int sum(int[] array){
        if (array == null) {
            return 0;
        }
        int sum = 0;
        for (int number:array) {
            if (number%2==0){
                sum +=number;
            }
        }
        return sum;
    }
}
