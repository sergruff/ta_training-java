package com.epam.training.student_Sergei_Bespalov;


class CycleSwap {
    static void cycleSwap(int[] array) {
        if (array.length<=1) {return;}
        int temp = array[array.length-1];
        for (int i=0;i<array.length;i++) {
            int temp2 = array[i];
            array[i] = temp;
            if (i!=array.length-1) {temp = temp2;}
        }
    }

    static void cycleSwap(int[] array, int shift) {
        if (array.length<=1) {return;}
        shift = shift%array.length;
        if (shift==0) {return;}
        int[] temp = new int[array.length];
        for (int i=0;i<array.length;i++) {
            temp[i] = array[(array.length-shift+i)%(array.length)];
        }
        for (int i=0;i<array.length;i++) {
            array[i] = temp[i];
        }

    }
}
