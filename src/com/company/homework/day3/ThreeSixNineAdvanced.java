package com.company.homework.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 369게임+
 *
 * 369게임에 참여했을 때, 내가 외쳐야 하는 숫자나 동작을 순서대로 출력하시오.
 *
 * 규칙
 * 1. 3, 6, 9, 5가 포함되지 않은 숫자는 숫자를 외친다. (2!)
 * 2. 숫자에 포함된 3, 6, 9의 개수 만큼 박수를 친다. (짝!)
 * 3. 숫자에 포함된 5의 개수 만큼 발을 구른다. (쿵!)
 * 4. 박수와 발구르기의 순서는 관계 없으나, 반드시 번갈아 수행한다.
 *
 * 예시
 * 2   -> 2!
 * 33  -> 짝!짝!
 * 553 -> 쿵!짝!쿵! (짝!쿵!쿵!x)
 * 47  -> 47!
 *
 * 인자
 * gameLength: 게임이 종료되는 데 걸리는 턴 수
 * numPeople: 게임에 참여하는 인원 수
 * myTurn: 내가 숫자를 외치는 순번
 */

public class ThreeSixNineAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gameLength = scanner.nextInt();
        int numPeople = scanner.nextInt();
        int myTurn = scanner.nextInt();


        for(int i = 1; i <= gameLength; i++){
            int count369 = 0;
            int count5 = 0;
            int digitSize = countSize(gameLength);

            if(i % numPeople != myTurn)
                continue;

            int currentNum = i;
            for(int j = 0; j < digitSize; j++){
                int num = currentNum % 10; // 한 자리수
                currentNum = currentNum / 10; // 첫번째 자리 자르고 남은 수

                if(num == 3 || num == 6 || num == 9) {
                    count369++;
                } else if( num == 5) {
                    count5++;
                }
            }

            if(count5 == 0 && count369 == 0) {
                System.out.println(i + "!");
            } else {
                for(int j = 0; j < whatIsLittle(count369, count5); j++) {
                    if (count369 > count5) {
                        System.out.print("짝!쿵!");
                    } else {
                        System.out.print("쿵!짝!");
                    }
                }
                remainBehavior(count369, count5);
                System.out.println("");
            }

        }





    }

    public static int countSize(int gameLength) {
        int digitSize = 1;
        int maxDigit;
        while(true) {
            maxDigit = 1;
            for(int i = 0; i < digitSize; i++){
                maxDigit *= 10;
            }
            if(gameLength > maxDigit) {
                digitSize++;
            } else {
                break;
            }
        }

        return digitSize;
    }

    public static void remainBehavior(int threeSixNine, int five){
        if(threeSixNine > five){
            for(int i = 0; i < threeSixNine - five; i++){
                System.out.print("짝!");
            }
        } else {
            for(int i = 0; i < five - threeSixNine; i++){
                System.out.print("쿵!");
            }
        }
    }

    public static int whatIsLittle(int threeSixNine, int five){
        if(threeSixNine > five){
            return five;
        } else {
            return threeSixNine;
        }
    }
}

