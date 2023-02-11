package com.epam.training.student_Sergei_Bespalov;

import java.util.Locale;
import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double diskriminant =  Math.pow(b,2)-4*a*c;
        if (diskriminant>0) {
            double root1 = (-b-Math.sqrt(diskriminant))/(2*a);
            double root2 = (-b+Math.sqrt(diskriminant))/(2*a);
            System.out.println(root1+" "+root2);
        } else if (diskriminant==0) {
            double root = (-b)/(2*a);
            System.out.println(root);
        } else {
            System.out.println("no roots");
        }


    }

}