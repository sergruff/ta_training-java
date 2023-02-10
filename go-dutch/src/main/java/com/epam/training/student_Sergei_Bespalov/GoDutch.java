package com.epam.training.student_Sergei_Bespalov;

import java.util.Scanner;

public class GoDutch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int bill = scan.nextInt();
        if (bill < 0) {
            System.out.println("Bill total amount cannot be negative");
            return;
        }
        int friends = scan.nextInt();
        if (friends<=0) {
            System.out.println("Number of friends cannot be negative or zero");
            return;
        }
        double part = bill*1.1/friends;
        System.out.println((int)part );
    }
}
