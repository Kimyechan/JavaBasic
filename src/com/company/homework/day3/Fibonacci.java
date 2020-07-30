package com.company.homework.day3;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seqLength = scanner.nextInt();
        Long num1 = 0L;
        Long num2 = 1L;
        // write codes here

        if(seqLength == 1) {
            System.out.println("0");
        } else if(seqLength == 2){
            System.out.println("0 1");
        } else {
            System.out.print("0 1");
            for (int i = 0; i < seqLength - 2; i++) {
                Long temp = num2;
                num2 = num2 + num1;
                num1 = temp;
                System.out.printf(" %d", num2);
            }
            System.out.println("");
        }
    }

}
