package com.company.ch05.se09.p01;

/**
 * 디자인 패턴(Design Pattern)
 * - 자주 발생하는 문제를 쉽게 해결하기 위해 제시된 재사용 가능한 해결책
 *  - Don't reinvent the wheel
 * - 소프트웨어 설계 문제를 쉽게 해결할 수 있도록 패턴화된 설계 방식
 * - 팀원들과의 소통을 위해 디자인 패턴 학습이 필요
 *
 * - 문맥 -> 문제 -> 해결
 */

/**
 * Singleton
 * - 단 하나의 객체만 존재하도록 하는 클래스
 * - 프로그램 전체의 '상태'를 정의하는 데에 많이 사용
 * - 예를 들면 게임의 진행 상태, GUI 전체를 통솔
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) { // Lazy 객체화
            instance = new Singleton();
        }
        // 로딩속도 개선,  메모리 낭비 방지 -> 객체가 사용되지 않을 때 생성하지 않음
        return instance;
    }
}
public class Main {

}
