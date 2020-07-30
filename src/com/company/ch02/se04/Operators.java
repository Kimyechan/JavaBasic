package com.company.ch02.se04;

/**
 * 연산자(Operator)
 * 연산자(Operator), 피연산자(Operand) -> 연산식(Expression)
 * 사칙 연산자 -> * / + -
 * 비교 연산자 >= <= > <
 * 논리
 * 비트
 * 증감
 * 삼항
 */
public class Operators {

    public static void main(String[] args) {
        int x = 10, y = 20, z;

        // 사칙 연산
        z = x + y; // +:연산자, x, y: 피연산자, x + y : 연산식(Expression)
        // =:연산자 z, x+y : 피연산자
        System.out.println(z);

        System.out.println("정수형 사칙 연산");
        System.out.println(20 - 5);
        System.out.println(5 + 20);
        System.out.println(10 * 662);
        System.out.println(150 / 8); // 정수 나누기 -> 몫
        System.out.println(150 % 8); // modulus, 나머지

        System.out.println("실수형 사칙 연산");
        System.out.println(10.0 + 52.3);
        System.out.println(10.5f + 12.3); // float, double 연산 -> double
        System.out.println(10.4 - 50); // 실수형, 정수형 연산 -> 실수형
        System.out.println(10.2 * 4.2);
        System.out.println(150 / 8.0); //실수로 나수면 소수점까지 계산
        System.out.println(5.2 / 1.2); //몫이 아니고 실수 값으로 연산
        System.out.println(5.2 % 1.2); //실수 나눗셈도 modulus 연산으로 나머지 계산 가능
        System.out.println("");

        System.out.println("사칙연산 주의사항");
        System.out.println(Integer.MAX_VALUE/2 * 3);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1); // 가장 큰 값에서 오버플로우 발생 시 가장 작은 갑이 된다.

        System.out.println((6 - 5.9) * 10);
        System.out.println(Math.floor((6 - 5.9) * 10)); //정밀 문

        System.out.println(40 / 0.0); // Infinity
        System.out.println(40 % 0.0); // NaN

        //대입 연산자
        z = x + y;
        z += 10; // z = z + 10;
        z %= 2;
        // 논리연산자, 비트연산자 등등 다 됨

        //비교 연산자
        System.out.println("비교 연산자");
        System.out.println(10 > 20);
        System.out.println(10 < 20);
        System.out.println(10 >= 10);

        x = 10;
        y = 10;
        System.out.println(x == y);
        System.out.println(x != y);
        System.out.println("");

        // 논리 연산자 - 입출력 모두 boolean
        // a AND b : a, b 모두 참 일때만
        // a OR b : a 또는 b 둘 중 하나만 참이여도 참
        // a XOR b : a 또는 b 둘 중 하나만 참이여야 참 // exclusive or, 배타적 OR
        // NOT a : a가 참이면 거짓, 거짓이면 참 -> 단항 연산자
        System.out.println(10<20 & 40 >= 2); // AND
        System.out.println(40 < 2 | 1 > 0); // OR
        System.out.println(!(10 > 20)); //NOT
        System.out.println(10 > 2 ^ 5 < 2); //XOR
        System.out.println("");

        // short-circuit 앞에꺼만 보고 결과 출력
        System.out.println(10 < 20 && 4 < 2);
        System.out.println(10 < 20 || 4 < 2);

        int val = 0;

        System.out.println(val++); // val = 0으로 먼저 Expression 평가 후에 val += 1 적용
        //sout(val)
        //val += 1
        System.out.println(++val);
        //val += 1
        //sout(val)
        System.out.println(val--);
        //sout(val)
        //val -= 1
        System.out.println(--val);
        //val -= 1
        //sout(val)

        val = 5;
        int new_val = val++ * 10 + --val; //후위 연산자는 자신의 가장 우선순위가 높은 연산을 하나만 하고 증감연산 진행
        System.out.println(new_val);
        System.out.println("");

        //삼항 연산자
        //(cond)?(true expression):(false expression)
        //boolean 값
        System.out.println(true?1:0);
        System.out.println(false?1:0);

        x = 10;
        y = 13;
        System.out.println(x > y? x:y);
        System.out.println(x < y? x:y);

        //비트 연산자
        //정수형 연산에 사용
        System.out.printf("b%32s\n", Integer.toBinaryString(8));
        System.out.printf("b%32s\n", Integer.toBinaryString(8 >> 1)); // shift 연산자
        System.out.printf("b%32s\n", Integer.toBinaryString(7));
        System.out.printf("b%32s\n", Integer.toBinaryString(1423));
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 >> 2));
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 >> 4));
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 << 2)); // 왼쪽 0
        System.out.printf("b%32s\n", Integer.toBinaryString(1423 << 4));

        System.out.printf("b%32s\n", Integer.toBinaryString(-1 ));
        System.out.printf("b%32s\n", Integer.toBinaryString(-1 >> 1)); // 왼쪽 1
        System.out.printf("b%32s\n", Integer.toBinaryString(-1 >>> 1)); //sign 비트와 무관하게 0

        int intVal = 4123;
        intVal >>= 2;
        intVal |= 412;

        System.out.printf("b%32s\n", Integer.toBinaryString(1252));
        System.out.printf("b%32s\n", Integer.toBinaryString(15234));
        System.out.printf("b%32s\n", Integer.toBinaryString(1252 & 15234));
        System.out.printf("b%32s\n", Integer.toBinaryString(1252 | 15234));
        System.out.printf("b%32s\n", Integer.toBinaryString(1252 ^ 15234));
        System.out.printf("b%32s\n", Integer.toBinaryString(~1252)); //논리연산자처럼 보이지만 비트연산자이다.

        int a = 0;
        int b = 0;

        System.out.println(a>0 & b>0);
        System.out.println(a++ > 0 & b++ > 0);
        System.out.println(a + " , " + b);

        a = 0;
        b = 0;
        System.out.println(a++ > 0 && b++ > 0);
        System.out.println(a + " , "+ b);

        // && -> 하나만 거짓이여도 뒤에것은 계산하지 않음
        // || -> 하나만 참이여도 뒤에것은 계산하지 않음
    }
}