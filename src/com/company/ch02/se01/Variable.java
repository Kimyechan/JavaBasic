package com.company.ch02.se01;

/**
 * 변수
 * 변하는 수, 수학의 변수와 유사하다.
 * 변수의 타입, 변수명, 값 할당
 * 변수의 선언
 * 변수에 값 할당(리터럴)
 * 변수명 규칙
 */
public class Variable {
    static int STATIC_VARIABLE = 10; //상수는 전체 대문자, _ 로  구성

    public static void main(String[] args) {
        int x;
        x = 10; //10 -> 리터럴
        System.out.println(x);

        int y, z, value;

        int valueOne = 10;
        int valueTwo = 20;

        int valueThree = 100, valueFour = 1000;
        int intOne;

        //변수명 사용 불가 예
        //int int; 예약어
        //int 4thWord; 앞에 숫자
        //int fwei*wfe; 특수문자
        int $power; //$가능하지만 쓰지마라

        //Code Convention
        int valueOfComputer; //->camelCase
        int ValueOfComputer; //->PascalCase
        //변수명은 camelCase
        //클래스, 인터페이스, Enum, 애너테이션은 PascalCase

        int _8thWord;

    }
}
