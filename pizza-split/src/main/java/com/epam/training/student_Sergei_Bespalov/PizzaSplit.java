package com.epam.training.student_Sergei_Bespalov;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int people = scan.nextInt();
        int pts = scan.nextInt();
        int pizzas;
        for (pizzas=1;pizzas*pts%people!=0;pizzas++){
        }
        System.out.println(pizzas);
    }
}
