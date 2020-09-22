package com.company.homework.day12;

import java.util.HashMap;

/**
 * 람다식을 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 *
 * 주어진 interface와 실행 메소드를 이용하여 알고리즘 정답을 테스트하는 프로그램을 작성하시오.
 * 이 테스트 방식을 이용하여 실제 알고리즘 문제를 하나 이상 풀이하시오.
 *
 */

interface Solution<T, R> {
    R solve(T t);
}

class Algorithm<T, R> {
    boolean test(T input, R groundTruth, Solution<? super T, ? super R> solution) {
        // TODO: solution을 실행하고, 이것이 정답(groundtruth)와 일치하는지 테스트하여 일치 여부를 출력.
        Integer testResult = (Integer) solution.solve(input);
        return groundTruth == testResult;
    }
}

public class LambdaExpressions {
    public static void main(String[] args) {
        // TODO: test를 이용하여 알고리즘 문제를 하나 이상 풀이하고 테스트 결과를 출력하시오.
        Algorithm<String[][], Integer> algorithm = new Algorithm<>();
        String[][] input = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        Integer groundTruth = 5;

        Boolean isCorrect = algorithm.test(input, groundTruth, (testCase) -> {
            HashMap<String, String> clothesHash = new HashMap<>();
            HashMap<String, Integer> kindHash = new HashMap<>();

            for (String[] clothe : testCase) {
                clothesHash.put(clothe[0], clothe[1]);
                if (kindHash.containsKey(clothe[1])) {
                    kindHash.put(clothe[1], kindHash.get(clothe[1]) + 1);
                } else {
                    kindHash.put(clothe[1], 1);
                }
            }

            Integer answer = 1;
            for(int value : kindHash.values()) {
                answer *= (value + 1);
            }

            return answer-1;
        });

        if(isCorrect) {
            System.out.println("정답");
        } else {
            System.out.println("틀렸습니다");
        }
    }
}
