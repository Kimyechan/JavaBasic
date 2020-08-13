package com.company.ch05.se01;

/**
 * Wrapper 클래스
 * char -> Character
 * short -> Short
 * int -> Integer
 * long -> Long
 * float -> Float
 * double -> Double
 * boolean -> Boolean
 */
public class WrapperClass {
    public static Integer add(Integer x, Integer y) {
        return x + y; //unboxing
        //자동으로 기본자료형으로 변형되어서 계산
        //변환시에 자동으로 AutoBoxing이 이루어짐
    }

    public static <T> T bypass(T x){
        return x;
    }
    public static void main(String[] args) {
        Integer integer = new Integer(10);
        Integer integer1 = Integer.valueOf(10);

        Character character = new Character('d');
        Character character1 = Character.valueOf('d');

        //Autoboxing
        Integer integer2 = 4;
        System.out.println(add(4, 2));

        bypass(5); // autoboxing
        // T: Wrapper classdls Integer로 결정됨
        // 5 -> new Integer(5) (Autoboxing)

        //문자열 <-> 기본 자료형
        int x = Integer.parseInt("100"); // parse+자료형 정적 메소드
        int y = new Integer("100");
        int z = Integer.valueOf("200");


    }
}
