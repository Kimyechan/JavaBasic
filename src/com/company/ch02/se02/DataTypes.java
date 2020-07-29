package com.company.ch02.se02;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.PropertyResourceBundle;

/**
 * 자료형(Data Type)
 * 자료형 - 기본형(Primitive Type), 참조형(Reference Type)
 * 기본형 자료형 - 정수형, 실수형, 문자형, 논리형
 * 참조형 자료형 - 문자열(String)
 */
public class DataTypes {

    public static void main(String[] args) {
        //정수형: byte, short, int, long
        System.out.println("Byte");
        System.out.println(Byte.BYTES);
        byte byteValue = 42;
        System.out.println(byteValue);
        System.out.println(Byte.MAX_VALUE); //2^7-1
        System.out.println(Byte.MIN_VALUE); // -2^7
//        byte byteValue1 = 128;
        System.out.println("");

        System.out.println("Short");
        System.out.println(Short.BYTES);
        System.out.println(Short.MAX_VALUE); //2^15-1
        System.out.println(Short.MIN_VALUE); //-2^15
        System.out.println("");

        System.out.println("Int");
        System.out.println(Integer.BYTES);
        System.out.println(Integer.MAX_VALUE); //2^31-1
        System.out.println(Integer.MIN_VALUE); //-2^31
        System.out.println("");

        System.out.println("Long");
        System.out.println(Long.BYTES);
        System.out.println(Long.MAX_VALUE); //2^63-1
        System.out.println(Long.MIN_VALUE); //-2^63
        System.out.println("");

        //OverFlow
        short shortValue = (short)64000;
        System.out.println(shortValue);

        //정수형은 기본적으로 int
        //byte byteValue3 =  144;
        short shortA = 10;
        short shortB = 20;
        short shortC = (short)(shortA + shortB); //short 둘을 더하면 오버플로우 발생할 수 있다 -> int형으로 지동 형 변환 된다.

        int bigInt = Integer.MAX_VALUE;
        int biggerInt = bigInt + 1; //overflow 주의
        System.out.println(biggerInt);

        long veryBigInt = 10000000000000L;
        long veryBigInt1 = 100_000_000_000L;
        System.out.println(veryBigInt);


        // 진수법 - Binary(2), Octal(8), Decimal(10), Hexadecimal(16)
        System.out.println(0b1101); //2진수
        System.out.println(071);
        System.out.println(1423);
        System.out.println(0x10); //0~9 10~15: a b c d e f
        System.out.println(0xff);

        //실수형 float, double
        System.out.println("float"); // 4
        System.out.println(Float.BYTES);
        System.out.println(Float.MAX_VALUE); // 3.4028235E38
        System.out.println(Float.MIN_VALUE); // 1.4E-45 : resolution
        System.out.println("");

        System.out.println("double");
        System.out.println(Double.BYTES); // 8
        System.out.println(Double.MAX_VALUE); // 1.8 * 10^308
        System.out.println(Double.MIN_VALUE); // 4.9 * 10^324
        System.out.println("");

        //실수형 기본형은 double
        float floatVal = 1.423f;
        float floatVal2 = (float)1.423;

        double doubleVal = 104.413124123;
        double doubleVal2 = 1.423e8;
        double doubleVal3 = 1.423E8;

        //문자형 char
        System.out.println("char"); // 양수 값만 가짐
        System.out.println(Character.BYTES); // 2
        System.out.println((int)Character.MAX_VALUE); // 65535(2^16 - 1)
        System.out.println((int)Character.MIN_VALUE); // 0
        System.out.println("");

        char charVal = 'A';
        System.out.println(charVal);
        System.out.println((int)charVal);
        System.out.println('\'');
        System.out.println('"');
        System.out.println('\"');

        System.out.println('\u0041'); // 41 -> 65
        System.out.println((char)65);
        System.out.println("");

        //논리형
        System.out.println("boolean");
        System.out.println(Boolean.TRUE);
        System.out.println(Boolean.FALSE);

        boolean isTrue = true;
        boolean isFalse = false;
        System.out.println("");

        // isTrue = 1; //논리형 리터럴이 아니면 안됩니다.
        // isFalse = 0

        //문자열 (String)
        System.out.println("String");

        String s = "This is a new string.";
        System.out.println(s);

        String s1 = "This" + "is" + "also" + "a string.";
        System.out.println(s1);

        int intValue = 20;
        String s2 = "String + Integer = " + intValue; //자동으로 스트링으로 변환 후 연결
        System.out.println(s2);

        String s3 = "String + Integer = " + Integer.valueOf(intValue).toString();
        System.out.println(s3);
        System.out.println("");

        //형변환(Type Casting)
        System.out.println("Casting");
        int intValue1 = (int)100.9; //소수부분 소실
        System.out.println(intValue1);

        // Upcasting
        System.out.println("Upcasting"); // 범위가 작은 족 -> 범위가 큰 쪽, 정밀도가 낮은 쪽 -> 정밀도가 큰 쪽
        byte byteVal1 = 10;
        int intVal = byteVal1;
        intVal = (int)byteVal1; // Upcasting은 자동으로 됩니다.

        intVal = 10244;
        long longVal = intVal;
        longVal = (long)intVal;

        float floatVal1 = longVal; //long -> float은 Upcasting float(4byte), long(8byte)
        floatVal1= (float)longVal; //Upcasting 자동으로 이루어짐

        double doubleVal1 = floatVal1;
        doubleVal1 = (double)floatVal1;


        //Downcasting
        long longVal1 = 104244L;
        //int intVal = longVal; //Downcasting은 자동으로 이루어지지 않음
        int intVal1 = (int)longVal1;
        System.out.println(intVal1);

        longVal1 = 100_000_000_000L;
        intVal1 = (int)longVal1;
        System.out.println(intVal1); //Downcasting 하면서 상위 비트 소실

        char charVal1 = 4123;
        byte byteVal = (byte)charVal1;
        System.out.println(byteVal);

    }
}
