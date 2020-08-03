package com.company.homework.day5;

import java.util.ArrayList;
import java.util.List;

public class DomainReverse {
    public static void main(String[] args) {
        solution1();
        solution2();
    }

    private static void solution1(){
        String domain = "www.google.com";
        char [] domainChar = domain.toCharArray();
        List<String> stringArray = new ArrayList<>();
        List<String> stringArrayReverse = new ArrayList<>();

        int start = 0;
        int end;
        for(int i = 0; i < domain.length(); i++){
            if(domainChar[i] == '.'){
                end = i;
                stringArray.add(domain.substring(start, end));
                start = i+1;
            }
            if(i == domain.length() - 1) {
                end = i;
                stringArray.add(domain.substring(start, end+1));
            }
        }

        for(String domainName : stringArray){
            char[] array = domainName.toCharArray();
            for(int i = 0; i < domainName.length(); i++){
                char temp =  domainName.charAt(i);
                array[i] = domainName.charAt(domainName.length() - i - 1);
                array[domainName.length() - i - 1] = temp;
            }
            stringArrayReverse.add(String.valueOf(array));
        }

        for(int i = 0; i < stringArrayReverse.size() - 1; i++){
            System.out.print(stringArrayReverse.get(i) + ".");
        }
        System.out.println(stringArrayReverse.get(stringArrayReverse.size() - 1));
    }

    private static void solution2() {
        String domain = "www.google.com";
        String[] domainArray = domain.split("\\.");

        StringBuffer domainReverse = new StringBuffer();

        for(int i = 0; i < domainArray.length - 1; i++) {
            StringBuffer reverseValue = new StringBuffer(domainArray[i]);
            domainReverse.append(reverseValue.reverse()+".");
        }
        StringBuffer reverseValue = new StringBuffer(domainArray[domainArray.length -1]);
        domainReverse.append(reverseValue.reverse());
        System.out.println(domainReverse);
    }
}
