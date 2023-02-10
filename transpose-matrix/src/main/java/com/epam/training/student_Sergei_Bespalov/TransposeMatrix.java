package com.epam.training.student_Sergei_Bespalov;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] temp = new int[matrix[0].length][matrix.length];
        for (int i=0; i<temp.length; i++){
            for (int j=0; j<temp[0].length; j++) {
                temp[i][j] = matrix[j][i];
            }
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println("Test your code here!\n");
        int[][] matrix = {
                {1, 2, 5},
                {7, -13, 3} };
        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
