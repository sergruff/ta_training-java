package com.epam.training.student_Sergei_Bespalov;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int secondsTime = seconds%60;
        int minutes = seconds/60;
        int minutesTime = minutes%60;
        int hours = seconds/3600;
        int hoursTime = hours%24;
        System.out.println(hoursTime+":"+minutesTime/10+minutesTime%10+":"+secondsTime/10+secondsTime%10);


    }
}
