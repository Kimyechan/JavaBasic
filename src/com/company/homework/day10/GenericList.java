package com.company.homework.day10;

/**
 * List<T> 제네릭 인터페이스를 구현하여 ArrayList<T> 제네릭을 완성하시오.
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
 * ArrayList<T>는 Object []를 이용하여 List<T>를 구현한다.
 * - 생성자에서는 capacity를 입력받으며, 배열의 크기가 부족할 때마다 2배씩 증가시킨다.
 */

interface List<T> {
    void append(T value);
    void prepend(T value);
    void insert(int index, T value);
    void remove(int index);
    T get(int index);
    int length();
}

class ArrayList<T> implements List<T>{
    private int capacity;
    private int maxIndex;
    private Object[] array;

    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity+1];
    }

    @Override
    public void append(T value) {
        if(maxIndex < capacity){
            array[maxIndex] = value;
        } else {
            Object[] tempArray = array;
            array = new Object[capacity*2];
            for(int i = 0; i < capacity; i++){
                array[i] = tempArray[i];
            }
            capacity = capacity * 2;
            array[maxIndex] = value;
        }
        maxIndex++;
    }

    @Override
    public void prepend(Object value) {
        if(maxIndex < capacity){
            Object[] tempArray = new Object[array.length];
            System.arraycopy(array, 0, tempArray, 0, array.length);
            for(int i=0; i < maxIndex; i++){
                array[i+1] = tempArray[i];
            }
            array[0] = value;
        } else {
            Object[] tempArray = array;
            capacity *= 2;
            array = new Object[capacity];
            for(int i=0; i < maxIndex; i++){
                array[i+1] = tempArray[i];
            }
            array[0] = value;
        }
        maxIndex++;
    }

    @Override
    public void insert(int index, Object value) {
        if(index > maxIndex){
            System.out.println("범위를 벗어났습니다");
        } else {
            if (maxIndex < capacity) {
                Object[] tempArray = new Object[array.length];
                System.arraycopy(array, 0, tempArray, 0, array.length);
                for (int i = index; i < maxIndex; i++) {
                    array[i + 1] = tempArray[i];
                }
                array[index] = value;
            } else {
                Object[] tempArray = array;
                capacity *= 2;
                array = new Object[capacity];
                for (int i = 0; i < index; i++) {
                    array[i] = tempArray[i];
                }
                for (int i = index; i < maxIndex; i++) {
                    array[i + 1] = tempArray[i];
                }
                array[index] = value;
            }
            maxIndex++;
        }
    }

    @Override
    public void remove(int index) {
        if(index > maxIndex) {
            System.out.println("지울려는 인덱스의 값이 존재하지 않습니다.");
        } else {
            Object[] tempArray = new Object[array.length];
            System.arraycopy(array, 0, tempArray, 0, array.length);
            for (int i = index; i < array.length - 1; i++) {
                array[i] = tempArray[i + 1];
            }
            array[array.length - 1] = 0;
            maxIndex--;
        }
    }

    @Override
    public T get(int index) {
        if(index > maxIndex) {
            System.out.println("해당 인덱스 값이 존재하지 않습니다.");
            return null;
        } else {
            return (T) array[index];
        }
    }

    @Override
    public int length() {
        return maxIndex;
    }
}


public class GenericList {
    public static void printList(ArrayList<Double> list) {
        for (int i = 0; i < list.length(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<Double>(10);
        for (int i = 0; i < 20; i++) {
            list.append((double) i);
        }
        printList(list);

        list.remove(5);
        printList(list);

        list.prepend(1);
        list.prepend(2);
        list.prepend(3);
        printList(list);

        list.insert(5, 100);
        printList(list);
        System.out.println(list.get(7));
        System.out.println(list.length());
    }
}