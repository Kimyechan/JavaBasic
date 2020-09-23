package com.company.ch05.se04.p07;

import java.util.function.*;

/**
 * Function 계열
 * - Mapping: 입력 -> 출력의 Mapping을 하는 함수형 인터페이스
 * - 입력 타입과 출력 탕빙느 다를 수 있다.
 */
public class Main {
    public static void main(String[] args) {
        Function<String, Integer> func = (s) -> s.length();
        System.out.println(func.apply("Four"));

        BiFunction<String, String, Integer> funcTwo = (s, u) -> s.length() + u.length();
        System.out.println(funcTwo.apply("A", "BCDFIOWKES"));

        //P Type Function은 입력을 P타입으로 받는다.
        IntFunction<String> funcThree = value -> String.valueOf(value);
        System.out.println(funcThree.apply(512));

        //ToP Type Function은 출력을 P타입으로 한다.
        ToIntFunction<String> funcFour = (s) -> s.length();
        // 출력이 P타입인 경우에는 ASP가 들어간다.
        System.out.println(funcFour.applyAsInt("ABCDE"));
        //ToIntBiFunction<String, String>
        //P : Int, Long, Double


        // PToQFunction : P -> Q로 매핑하는 함수
        IntToDoubleFunction funcFive;
        // IntToIntFunction은 없다
    }
}
