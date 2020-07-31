package com.company.ch02.se07;

/**
 * N-D 배열 (N-D Arrays)
 * 배열이 배열을 담고 있으면, 다차원 배열이라 한다.(N-D Array)
 * 수학에서 말하는 점 -> 선 -> 면 -> 공간 -> 4차원 -> 5차원
 */
public class NDArrays {
    public static void main(String[] args) {
        int[][] ints;
//        int [] halfCStyle[];
//        int oldStyle[][];

        int [][] ints1 = new int[10][10];

        int [][] ints2 = new int[10][];
        for(int i = 0; i < ints2.length; i++){
            ints2[i] = new int[5];
        }

        int [][] ints3 = new int[5][]; //하위 차원의 길이는 달라질 수 있다.
        ints3[0] = new int[10];
        ints3[1] = new int[8];
        ints3[2] = new int[4];
        ints3[3] = new int[15];
        ints3[4] = new int[9];

        int[][] ints4 = {{1, 2, 3}, {4, 5, 6}}; //[2][3]
        int[][] ints5 = {{1, 2, 3}, {2, 3}, {4, 5, 3}}; //int[3][]
        for(int i = 0; i < ints5.length; i++){
            System.out.printf("[%d] :", ints5[i].length);
            for(int j = 0; j < ints5[i].length; j++){
                System.out.printf("%d ", ints5[i][j]);
            }
            System.out.println("");
        }

        for(int [] array : ints5) {
            for(int val : array) {
                System.out.printf("%d ", val);
            }
            System.out.println("");
        }

    }
}
