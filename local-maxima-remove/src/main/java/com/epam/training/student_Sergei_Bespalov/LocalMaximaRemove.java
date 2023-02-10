package com.epam.training.student_Sergei_Bespalov;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[1000];
        Arrays.fill(array, 15);
        array[0] = 20;
        array[999] = 25;
        array[168] = 30;
        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array) {
        int[] resultArray = new int[array.length];
        int resultArrayMarker = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (array[0] <= array[1]) {
                    resultArray[resultArrayMarker] = array[i];
                    resultArrayMarker++;
                }
                continue;
            } else if (i == array.length-1) {
                if (array[i-1] >= array[i]) {
                    resultArray[resultArrayMarker] = array[i];
                    resultArrayMarker++;
                }
                continue;
            }
            if (array[i - 1] >= array[i] || array[i] <= array[i + 1]) {
                resultArray[resultArrayMarker] = array[i];
                resultArrayMarker++;
            }
        }
        return Arrays.copyOf(resultArray, resultArrayMarker);
    }
}
