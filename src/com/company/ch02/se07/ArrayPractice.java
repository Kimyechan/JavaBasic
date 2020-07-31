package com.company.ch02.se07;

public class ArrayPractice {
    public static void main(String[] args) {
        int[] integers = {4, 2, 12, 23, 63, 9, 0, -4, -6};

        int max = Integer.MIN_VALUE;
        for(int value : integers) {
            if(max < value) {
                max = value;
            }
        }
        System.out.println(max);

        //2. 위 배열에서 2번재로 큰 값을 찾는 프로그램을 작성하시오.
        int max2 = Integer.MIN_VALUE;
        for(int value : integers) {
            if(value == max)
                continue;
            if(max2 < value) {
                max2 = value;
            }
        }
        System.out.println(max2);


    }
}
