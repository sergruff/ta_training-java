package com.epam.training.student_Sergei_Bespalov;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        Scanner pass = new Scanner(System.in);
        if (pass.nextInt()==PASSWORD) {
            System.out.println("Hello, Agent"); }
        else {
             System.out.println("Access denied");
        }
        }
}
