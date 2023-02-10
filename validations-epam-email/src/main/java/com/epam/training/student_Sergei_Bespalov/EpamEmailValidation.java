package com.epam.training.student_Sergei_Bespalov;

import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email==null) return false;
        return Pattern.compile("\\w+_\\w+@epam.com").matcher(email).matches();

    }
}





