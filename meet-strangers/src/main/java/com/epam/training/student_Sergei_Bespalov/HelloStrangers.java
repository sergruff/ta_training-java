package com.epam.training.student_Sergei_Bespalov;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if (number>0) {
            String[] Names = new String[number];
            Scanner scanName = new Scanner(System.in);
            for (int i=0; i<Names.length;i++){
                Names[i] = scanName.nextLine();
            }
            for (String n: Names){
                System.out.println("Hello, "+n);
            }
        }
        if (number<0) {
            System.out.println("Seriously? Why so negative?");
        }
        if (number==0){
            System.out.println("Oh, it looks like there is no one here");
        }

    }
}
