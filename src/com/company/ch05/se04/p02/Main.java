package com.company.ch05.se04.p02;

@FunctionalInterface // 필수는 아니다.
interface Runner<T> {
    T run(); // 단 하나의 abstract method
    //T runTwo(); // abstract method가 2개 이상이면 오류 발
    default void method() {} // default 메소드는 상관이 없다.
}

public class Main {
    static void useRunner(Runner<?> runner){
        System.out.println(runner.run());
    }

    public static void main(String[] args) {
        useRunner(() -> "This is how to use runner");
    }
}
