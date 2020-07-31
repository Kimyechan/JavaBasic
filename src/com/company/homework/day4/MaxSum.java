package com.company.homework.day4;

/**
 * 배열의 연속합 최대 구하기
 *
 * 정수 배열에서 연속된 값의 합의 최대값을 구하시오.
 *
 * ex1) {1, 45, -2, 5, -6} => 1 + 45 + (-2) + 5 = 49
 * ex2) {-4, 5, 12, -7, 52, -5, 7} => 5 + 12 + (-7) + 52 + (-5) + 7 = 64
 *
 *
 * 인자
 * integers: 정수 배열
 */

public class MaxSum {
    public static void main(String[] args) {
        int [] integers = {-4, 7, 14, 9, -5, 4, 16, -22, 31, 10};
        // write codes here

        int [] sumArray = new int[(integers.length * (integers.length + 1)) / 2];
        int sumIndex = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < integers.length; i++) {
            sum = 0;
            for(int j = i; j < integers.length; j++) {
                sum = 0;
                for(int k = i; k < j; k++) {
                    sum += integers[k];
                }
                sumArray[sumIndex] = sum;
                System.out.printf("%d to %d => %d \n", i, j, sum);
                sumIndex++;
            }
        }

        for(int i = 0; i < sumArray.length; i++) {
            if(max < sumArray[i]){
                max = sumArray[i];
            }
        }
        System.out.println("");

        System.out.println("Max = " + max);
    }
}
