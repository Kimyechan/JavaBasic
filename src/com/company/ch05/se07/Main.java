package com.company.ch05.se07;

/**
 * 정규 표현식 (Regular Expression)
 * - 특정 조건에 맞는 문자열을 검색(Search) / 치환(Replace)를 하는 패턴 기반의 식
 * - 이메일, 전화번호 등 특정한 형식에 맞게 적혀 있는지 validation 하는데에 사용 가능
 * - Crawling 등 날것의 자료를 긁어 모았을 때 정리하는 데에 유
 */
public class Main {
    public static void main(String[] args) {
        // 정규표현식의 기본 메타 문자
        // ^x: x로 시작

        String str = "ID: tezla";
        System.out.println(str.matches("^I"));
    }
}
