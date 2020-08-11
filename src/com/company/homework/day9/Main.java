package com.company.homework.day9;

import javax.naming.PartialResultException;

/**
 * List 인터페이스를 구현하여 IntArrayList 클래스를 완성하시오.
 *
 * List는 순서가 있는 연속된 값으로, List 인터페이스에 선언되어 있는 메소드의 기능은 아래와 같다.
 *
 * - append(): List의 마지막에 value를 삽입한다.
 * - prepend(): List의 시작점에 value를 삽입한다. 기존의 데이터를 한 칸씩 뒤로 옮긴다.
 * - insert(): index에 value를 삽입한다. 기존 데이터를 한 칸씩 뒤로 옮긴다.
 * - remove(): index의 value를 삭제한다. 기존 데이터를 한 칸씩 앞으로 당긴다.
 * - get(): index의 value를 반환한다.
 * - length(): List의 길이를 출력한다.
 *
 * IntArrayList는 int []를 이용하여 List를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List {
    public void append(int value);
    public void prepend(int value);
    public void insert(int index, int value);
    public void remove(int index);
    public int get(int index);
    public void length();
}

class IntArrayList implements List {
    private int capacity;
    private int maxIndex;
    private int[] arrayInt;

    public IntArrayList(int capacity) {
        this.capacity = capacity;
        arrayInt = new int[capacity+1];
    }

    @Override
    public void append(int value) {
        if(maxIndex < capacity){
            arrayInt[maxIndex] = value;
        } else {
            int[] tempArrayInt = arrayInt;
            arrayInt = new int[capacity*2];
            for(int i = 0; i < capacity; i++){
                arrayInt[i] = tempArrayInt[i];
            }
            capacity = capacity * 2;
            arrayInt[maxIndex] = value;
        }
        maxIndex++;
    }

    @Override
    public void prepend(int value) {
        if(maxIndex < capacity){
            int[] tempArrayInt = new int[arrayInt.length];
            System.arraycopy(arrayInt, 0, tempArrayInt, 0, arrayInt.length);
            for(int i=0; i < maxIndex; i++){
                arrayInt[i+1] = tempArrayInt[i];
            }
            arrayInt[0] = value;
        } else {
            int[] tempArrayInt = arrayInt;
            capacity *= 2;
            arrayInt = new int[capacity];
            for(int i=0; i < maxIndex; i++){
                arrayInt[i+1] = tempArrayInt[i];
            }
            arrayInt[0] = value;
        }
        maxIndex++;
    }

    @Override
    public void insert(int index, int value) {
        if(index > maxIndex){
            System.out.println("범위를 벗어났습니다");
        } else {
            if (maxIndex < capacity) {
                int[] tempArrayInt = new int[arrayInt.length];
                System.arraycopy(arrayInt, 0, tempArrayInt, 0, arrayInt.length);
                for (int i = index; i < maxIndex; i++) {
                    arrayInt[i + 1] = tempArrayInt[i];
                }
                arrayInt[index] = value;
            } else {
                int[] tempArrayInt = arrayInt;
                capacity *= 2;
                arrayInt = new int[capacity];
                for (int i = 0; i < index; i++) {
                    arrayInt[i] = tempArrayInt[i];
                }
                for (int i = index; i < maxIndex; i++) {
                    arrayInt[i + 1] = tempArrayInt[i];
                }
                arrayInt[index] = value;
            }
            maxIndex++;
        }
    }

    @Override
    public void remove(int index) {
        if(index > maxIndex) {
            System.out.println("지울려는 인덱스의 값이 존재하지 않습니다.");
        } else {
            int[] tempArrayInt = new int[arrayInt.length];
            System.arraycopy(arrayInt, 0, tempArrayInt, 0, arrayInt.length);
            for (int i = index; i < arrayInt.length - 1; i++) {
                arrayInt[i] = tempArrayInt[i + 1];
            }
            arrayInt[arrayInt.length - 1] = 0;
            maxIndex--;
        }
    }

    @Override
    public int get(int index) {
        if(index > maxIndex) {
            System.out.println("해당 인덱스 값이 존재하지 않습니다.");
            return 0;
        } else {
            return arrayInt[index];
        }
    }

    @Override
    public void length() {
        System.out.println(maxIndex);
    }

    public int[] getArrayInt() {
        return arrayInt;
    }

    public void setArrayInt(int[] arrayInt) {
        this.arrayInt = arrayInt;
    }
}

public class Main {
    public static void main(String[] args) {
        IntArrayList intList = new IntArrayList(10);
        for(int i = 1; i < 21; i++){
            intList.append(i);
        }
        intList.remove(10);
        for(int i : intList.getArrayInt()){
            System.out.print(i + ", ");
        }
        System.out.println();
        intList.length();

        for(int i = 1; i < 10; i++){
            intList.prepend(i);
        }
        for(int i : intList.getArrayInt()){
            System.out.print(i + ", ");
        }
        System.out.println();
        intList.length();

        for(int i = 1; i < 11; i++){
            intList.insert(0, i);
        }
        for(int i = 3; i < 10; i++){
            intList.insert(4, i);
        }
        intList.insert(7, 100*(-1));
        for(int i : intList.getArrayInt()){
            System.out.print(i + ", ");
        }
        System.out.println();
        intList.length();

        System.out.println(intList.get(0));
    }
}
