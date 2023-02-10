package com.epam.training.student_Sergei_Bespalov;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int dimension1   =  matrix1.length;
        int dimension2 =  matrix2[0].length;
        int[][] multiplyMatrix = new  int[dimension1][dimension2];
        System.out.println("C["+ dimension1 + "]" + "["+ dimension2 + "]");

            for (int i=0; i<dimension1;i++) {
                for (int j = 0; j< dimension2; j++) {
                    int sum = 0;
                    for (int m1i=0; m1i<matrix1[0].length;m1i++) {
                        sum += matrix1[i][m1i]*matrix2[m1i][j];
                        System.out.println("A["+ i + "]" + "["+ m1i + "]" + matrix1[i][m1i] + "*" + "B["+ m1i + "]" + "["+ j + "]" + matrix2[m1i][j] + "=" + matrix1[i][m1i]*matrix2[m1i][j]);
                    }
                    multiplyMatrix[i][j] = sum;
                    System.out.println("C["+ i + "]" + "["+ j + "]" + sum);
                }
            }
        return multiplyMatrix;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {{51659, 30365, 64841, 96117, 55451, 22591, 40569, 25321, 58339, 26250, 69305, 49084, 12076}, {3439, 45985, 87410, 77067, 5087, 86128, 54127, 64639, 6021, 77016, 41259, 50585, 80707}, {30741, 9775, 24653, 55464, 12311, 267, 32355, 68933, 24090, 14462, 85355, 67548, 9601}, {83319, 89638, 83084, 74671, 27785, 34750, 81789, 96686, 24655, 32011, 40181, 74102, 40736}, {3879, 67733, 71257, 73674, 27556, 78450, 24756, 44488, 21857, 95236, 95465, 35919, 22744}, {9914, 53940, 65985, 29795, 43857, 86151, 37897, 32609, 71606, 1084, 78891, 71658, 48932}, {34700, 18862, 79414, 43394, 8089, 15978, 46819, 21736, 20821, 43601, 99152, 793, 97827}, {49965, 98957, 54165, 40459, 71642, 12228, 80062, 23056, 50800, 42727, 60010, 39243, 53417}, {14870, 50240, 15183, 91924, 79746, 25628, 6311, 6684, 36117, 28431, 90046, 34883, 57688}};
        int[][] b = {{27481, 70252, 54118}, {67541, 2285, 39871}, {99247, 39634, 48735}, {26742, 65506, 21323}, {76321, 54100, 29231}, {42347, 84323, 8636}, {3239, 6524, 6901}, {28650, 54253, 41668}, {73528, 53000, 81480}, {7253, 66776, 23161}, {4087, 3067, 26508}, {84090, 67460, 43128}, {79091, 77908, 23060}};


        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
