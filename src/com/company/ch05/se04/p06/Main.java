package com.company.ch05.se04.p06;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Supplier 계열
 * - 아무런 입력을 받지 않고, 값을 하나 반환하는 함수형 인터페이스
 * - 자료를 '공급'하는 역할을 한다.
 */
public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "A String";
        System.out.println(supplier.get());

        //BiSupplier -> 존재 X

        // Supplier는 P Type 계열에서 getAsP 메소드 출력
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean());
        // IntSupplier, LongSupplier, DoubleSupplier

        IntSupplier rollDice = () -> (int)(Math.random() * 6);
        for(int i = 0; i < 10; i++){
            System.out.println(rollDice.getAsInt());
        }
    }
}
