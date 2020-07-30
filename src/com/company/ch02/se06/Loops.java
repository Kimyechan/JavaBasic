package com.company.ch02.se06;

/**
 * 반복문(Loops)
 * for 문, while 문
 * 초기화 - 반복문을 실행하기 위해서 증감할 변수를 초기화
 * 조건식 - 반복문을 실행할 조건 (또는 종료할 조건)
 * 실행문 - 조건식이 참(또는 거짓)일 경우 실행할 코드
 * 증감식 - 실행문이 실행된 후에 변수에 증감을 주는 것
 */
public class Loops {
    public static void main(String[] args) {
        // for 문
        // 초기화 ; 조건식 ; 증감식
        for(int i = 0; i < 5; i++) {
            System.out.println(i); //실행문
        }
        System.out.println("");

        for(int i = 0; i < 5; i += 2) {
            System.out.println(i);
        }
        System.out.println("");

        for(int i = 4; i >= 0; i--) {
            System.out.println(i);
        }
        System.out.println("");

        //nested for
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.printf("(%d, %d)\n", i, j);
            }
        }

        for(int i = 0; i < 5; i++)
            System.out.print(i); // iterated
            System.out.println(""); //not iterated

        //while 문
        int i = 0;
        while(i < 5) {
            System.out.println(i);
            i++;
        }

        //do while 문
        i = 0;
        do {
            System.out.println(i);
            i++;
        } while(i < 5); //조건문이 false 여도 반드시 한 번 실행된다.

        //제어문 - break continue
        for(int j = 0; j < 10; j++){
            if(j == 3)
                continue;
            System.out.println(j);
        }

        for(int j = 0; j < 10; j++){
            if(j == 3)
                break;
            System.out.println(j);
        }

        outer: //레이블
        for(int j = 0; j < 5; j++){
            for(int k = 0; k < 5; k++){
                if(j == 3 && k == 2)
                    continue outer;
                System.out.printf("%d * %d = %d\n", j, k, j*k);
            }
        }
    }
}
