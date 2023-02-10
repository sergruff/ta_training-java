package com.epam.training.student_Sergei_Bespalov;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scan = new Scanner(System.in);
        int toReturn=Integer.MIN_VALUE;
        int input;
        do {
            input = scan.nextInt();
            if (input>toReturn&&input!=0) {
                toReturn=input;
            }
        }
        while (input != 0);
        return toReturn;
    }
    public static void main(String[] args) {
        System.out.println(max());
    }
}
