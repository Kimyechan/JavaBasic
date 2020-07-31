package com.company.ch02.se07;

public class NDArrayPractice {
    public static void main(String[] args){
        int [][] matA = {{1, 2, 3}, {4, 5, 6}};
        int [][] matB = {{3, 4, 5}, {1, 4, 2}};

        int [][] result1 = new int[2][3];

        for(int i = 0; i < matA.length; i++){
            for(int j = 0; j < matA[i].length; j++){
                result1[i][j] = matA[i][j] + matB[i][j];
                System.out.print(result1[i][j]);
            }
            System.out.println();
        }

        int [][] result2 = new int[3][2];
        for(int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[i].length; j++) {
                result2[j][i] = matA[i][j];
            }
        }

        for(int i = 0; i < result2.length; i++) {
            for (int j = 0; j < result2[i].length; j++) {
                System.out.print(result2[i][j]);
            }
            System.out.println();
        }


    }
}
