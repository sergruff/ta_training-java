package com.epam.training.student_Sergei_Bespalov;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int volume;
        int counter = 0;
        int sum =0;
        while ((volume=scanner.nextInt())!=0) {
            sum += volume;
            counter++;
            }
         System.out.println(sum/counter);
    }
}