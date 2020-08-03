package com.company.ch02.se07;

/**
 * 문자열은 내부적으로 '클래스'로 구성되어 있다.
 * 내부에는 문자의 배열로 된 데이터가 있따. cha[]
 * 한번 만든 문자열은 변하지 않는다. (immutable)
 */
public class _String {

    public static void main(String[] args) {
        String s1 = "문자열 생성 방법1";
        String s2 = new String("문자열 생성 방법2"); //클래스 생성자, 군장하지 않음

        String s3 = "abcde";
        String s4 = "abcde";
        String s5 = new String("abcde");

        System.out.println(s3 == s4); // true 메모리 참조값이 같음, 문자열을 곧바로 생성할 경우 상수 풀에서 찾아 사용
        System.out.println(s3 == s5); // false 메모리 참조값이 다름, 문자열을 클래스로 생성할 경우 새로운 값을 생성, 권장하지 않음

        System.out.println(s3.equals(s4));
        System.out.println(s3.equals(s5));

        String s = "This is a string.";
        System.out.println(s.length());
        System.out.println(s.charAt(2));
        System.out.println(s.indexOf('a'));
        System.out.println(s.equalsIgnoreCase("this Is A STRING.")); // 대소문자 관계없이 비교
        System.out.println(s.replace('i', 't')); //기존의 String을 바꾸는 것이 아니라, 변경된 String을 생성해서 출력
        System.out.println(s);
        System.out.println(s.substring(3, 9)); // index 3 ~ 8까지 새로운 String 생성 후 출력
        System.out.println(" wwefw ".trim()); //양옆 공백 제거
        System.out.println("*".repeat(10));

        char [] characters = s.toCharArray(); // 새로운 문자 배열을 만들어 반환
        for(char value : characters){
            System.out.println(value);
        }
    }
}
