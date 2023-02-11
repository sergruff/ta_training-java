package com.epam.training.student_Sergei_Bespalov;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        Scanner scanInt = new Scanner(System.in);
        int plusAtDay = scanInt.nextInt();
        int minusAtNight = scanInt.nextInt();
        int treeHeight = scanInt.nextInt();
        int position = 0;
        int daysNumber = 0;
        if (plusAtDay < treeHeight) {
            if (plusAtDay > minusAtNight) {
                do {
                    daysNumber++;
                    position += plusAtDay;
                    if (position>= treeHeight) {break;}
                    position -= minusAtNight;
                } while (position <= treeHeight);
                System.out.println(daysNumber);
            } else {
                System.out.println("Impossible");
            }
        } else {
            System.out.println("1");
        }

    }
}
