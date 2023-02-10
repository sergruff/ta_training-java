package com.epam.training.student_Sergei_Bespalov;

class Spiral {
    static int[][] spiral(int rows, int columns) {
        int[][] spiral = new int[rows][columns];
        int currentRow = 0;
        int currentColumn = 0;
        int spiralRound =0;
        int currentNum = 1;
        while (currentNum<=rows*columns) {
            for (int i = currentColumn; (i<=columns-1-spiralRound)&&(currentNum<=rows*columns); i++) {           //заполняем ряд до упора вправо
                spiral[currentRow][currentColumn] = currentNum;
                currentNum++;
                if (currentColumn!=columns-1- spiralRound) {currentColumn++;}
            }
            currentRow++;
            for (int i = currentRow; (i<=rows-1-spiralRound)&&(currentNum<=rows*columns); i++) {           //заполняем колонку до упора вниз
                spiral[currentRow][currentColumn] = currentNum;
                currentNum++;
                if (currentRow!=rows-1- spiralRound) {currentRow++;}
            }
            currentColumn--;
            for (int i = currentColumn; (i>=spiralRound)&&(currentNum<=rows*columns); i--) {           //заполняем ряд до упора влево
                spiral[currentRow][currentColumn] = currentNum;
                currentNum++;
                if (currentColumn!= spiralRound) {currentColumn--;}
            }
            currentRow--;
            spiralRound++;                                              // граница спирали - 1 единица
            for (int i = currentRow; (i!= spiralRound)&&(currentNum<=rows*columns); i--) {           //заполняем колонку до упора вверх
                spiral[currentRow][currentColumn] = currentNum;
                currentNum++;
                if (currentRow!= spiralRound) {currentRow--;}
            }
        }
        return spiral;
    }
}
