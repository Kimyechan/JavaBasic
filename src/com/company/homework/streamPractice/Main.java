package com.company.homework.streamPractice;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static int search(Integer n, Integer[] list) {
        int index = -1;

        for (int i = 0; i < list.length; i++) {
            if(list[i] == n) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static String reverse(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

    public static Integer maxinum(Integer[] list) {
        int max = list[0];
        for (int i = 0; i < list.length; i++) {
            if(max < list[i]) {
                max = list[i];
            }
        }
        return max;
    }

    public static Double average(List<Integer> list) {
        return list.stream()
                .mapToInt(i->i)
                .average()
                .getAsDouble();
    }

    public List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List<String> search(List<String> list) {
        return list.stream()
                .filter(s -> s.charAt(0) == 'a')
                .filter(s -> s.length() == 3)
                .collect(Collectors.toList());
    }

    public String getString(List<Integer> list) {
        return list.stream()
                .map(i -> ((i%2 == 0) ? "e" : "o") + i)
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {

    }
}
