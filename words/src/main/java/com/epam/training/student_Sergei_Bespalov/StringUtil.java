package com.epam.training.student_Sergei_Bespalov;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        int result=0;
        if(sample==null||(words==null)){
            return result;
        }
        for (String word : words) {
            if (word.trim().equalsIgnoreCase(sample.trim())) {
                result++;
            }
        }
        return result;

    }

    public static String[] splitWords(String text) {
        if(text==null||text.trim().equals("")) {
            return null;
        }
        Pattern p = Pattern.compile("[,.;: ?!]");
        Matcher m = p.matcher(text);
        if (m.replaceAll("").equals("")){
            return null;
        }
        text = m.replaceAll(" ");
        p = Pattern.compile(" +");
        return p.split(text.strip());
    }

    public static String convertPath(String path, boolean toWin) {
        if (path==null||path.strip().equals("")) {
            return null;
        }
        Pattern unix = Pattern.compile("(([.][.])|(\\w+)|([~.]?))(/((\\w* ?\\w*)|([.][.])))*(\\w*[.]\\w{3,4})?");
        Pattern windows = Pattern.compile("(([.]{0,2}\\\\)|(C:)|(\\w+))(((\\w* ?\\w*)|([.][.]))\\\\?)*(\\w*[.]\\w{3,4})?");
        Matcher unixM = unix.matcher(path);
        Matcher winM = windows.matcher(path);
        if (winM.matches()){
            System.out.println("win!");
            if (toWin) {
                System.out.println("return origin");
                return path;
            } else {
                System.out.println("Change to Unix!");//замена строки на Unix формат
                //меняем  C:\User на ~
                Pattern difference = Pattern.compile("C:\\\\User");
                Matcher change = difference.matcher(path);
                String result= change.replaceAll("~");
                // меняем первый / на C:
                difference = Pattern.compile("C:\\\\.*");
                if (difference.matcher(result).matches()) {
                    difference = Pattern.compile("C:\\\\");
                    change = difference.matcher(result);
                    result = change.replaceFirst("/");
                }
                // меняем \ на /
                difference = Pattern.compile("\\\\");
                change = difference.matcher(result);
                result = change.replaceAll("/");
                return result;
            }
        } else if (unixM.matches()){
            System.out.println("unix!");
            if (!toWin) {
                System.out.println("return origin");
                return path;
            } else {
                System.out.println("Change to win!");// замена строки на Win формат
                //меняем ~ на C:\User
                Pattern difference = Pattern.compile("~");
                Matcher change = difference.matcher(path);
                String result= change.replaceAll("C:\\\\User");
                // меняем первый / на C:
                difference = Pattern.compile("/.*");
                if (difference.matcher(result).matches()) {
                    difference = Pattern.compile("/");
                    change = difference.matcher(result);
                    result = change.replaceFirst("C:\\\\");
                }
                // меняем / на \
                difference = Pattern.compile("/");
                change = difference.matcher(result);
                result = change.replaceAll("\\\\");

                return result;
            }
        } else {
            System.out.println("Nothing!");
            return null;
        }
    }

    public static String joinWords(String[] words) {
        if (words==null||words.length==0) {
            return null;
        }
        StringJoiner builder = new StringJoiner(", ", "[", "]");
        for (String word : words) {
            if (!word.equals("")) {
                builder.add(word);
            }
        }
        if (builder.toString().equals("[]")) return null;
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}