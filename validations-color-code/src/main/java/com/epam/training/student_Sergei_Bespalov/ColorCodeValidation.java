package com.epam.training.student_Sergei_Bespalov;

import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if (color==null) return false;
       return Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$").matcher(color).matches();
    }
}





