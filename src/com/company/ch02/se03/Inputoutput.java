package com.company;

import java.util.Scanner;

/**
 * 자료 입출력
 * 출력 - print println printf, 포멧팅 방법
 * 입력 - 키보드 입력 받기
 */
public class Inputoutput {

    public static void main(String[] args) {
        //출력 메소드, println -> 오버로딩
        System.out.println("String can be printed");
        System.out.println('C');
        System.out.println(40324);
        System.out.println(1.423f);
        System.out.println(1523.124);

        System.out.print("12345\n");
        System.out.println("");

        System.out.printf("%s is for string\n", "String");
        System.out.printf("%s %s %s\n", "123", "1423", "15234");
        System.out.printf("%b\n", true);
        System.out.printf("%d 0x%x 0X%X 0%o\n", 15, 15, 15, 15);
        System.out.printf("%f\n", 14.23);
        System.out.printf("%f\n", 14.23f);
        System.out.printf("%e\n", 14.423);
        System.out.printf("%c %c\n", 'U', '\u0042');
        System.out.printf("%n"); // new line

        System.out.printf("%5d.\n", 10);
        System.out.printf("%-5d.\n", 10);
        System.out.printf("%05d.\n", 234);
        System.out.printf("%3d.\n", 12345); //3칸은 최소한 확보, 실제 출력은 다

        //실수 자릿수 표현
        System.out.printf("%5.4f\n", 112414.412312);
        System.out.printf("%5.2f\n", 1.425);
        System.out.printf("%-5.2f\n", 1.425);

        // 입력 메소드
        System.out.println("Input method");
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next(); //공백으로 구분된 String을 입력받는다
        System.out.println(s);

        //this is string
        //next() 메소드는 입력을 내용이 있을 때 까지 기다린다
        //Blocking 메소드라고 부른다. (<->non-blocking method)
        System.out.println(scanner.next()); // "this"
        System.out.println(scanner.next()); // "is"
        System.out.println(scanner.next()); // "string"

        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt()); //자료형 안 맞으면 에러발생

        // \n으로 구분이 되는 String을 입력받음
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
    }
}