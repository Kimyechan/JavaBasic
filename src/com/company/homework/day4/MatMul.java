package com.company.homework.day4;

public class MatMul {
    public static void main(String[] args) {
        int [][] matA = {{1, 2, 3} ,{4, 5, 2}};
        int [][] matB = {{5, 2}, {6, 2}, {1, 0}};
        // write codes here

        int [][] result = new int[matA.length][matB[0].length];
        for(int i = 0; i < matA.length; i++){
            for(int j = 0; j < matB[0].length; j++){
                for(int k = 0; k < matA[0].length; k++){
                    result[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }

        for(int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matB[0].length; j++) {
                System.out.printf("%3d", result[i][j]);
            }
            System.out.println();
        }

    }
}