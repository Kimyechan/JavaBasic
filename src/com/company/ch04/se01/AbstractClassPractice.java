package com.company.ch04.se01;


/**
 * AbstractStack
 *  -> Stack
 *
 *  is_empty() :
 *  push() :
 *  pop() :
 *  peek() :
 *
 */

abstract class AbstractStack {
    protected  int capacity;
    protected  int top;

    public AbstractStack(int capacity) {
        this.capacity = capacity;
        this.top = 0;
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public abstract void push(int value);
    public abstract int pop();
    public abstract int peek();
}

class ArrayStack extends AbstractStack {
    private int [] array;

    public ArrayStack(int capacity) {
        super(capacity);
        array = new int[capacity];
    }

    @Override
    public void push(int value) {
        if (top == capacity) {
            int[] new_array = new int[capacity * 2];
            for (int i = 0; i < array.length; i++){
                new_array[i] = array[i];
            }
            array = new_array;
        }
        array[top] = value;
        top++;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        return array[--top];
    }

    @Override
    public int peek() {
        return array[top - 1];
    }
}
public class AbstractClassPractice {
    public static void main(String[] args) {
        AbstractStack stack = new ArrayStack(10);

        for(int i = 0; i < 15; i++) {
            stack.push(i);
        } // 0 ~ 9

        System.out.println(stack.peek());
        System.out.println(stack.peek());

        for(int i = 0; i < 18; i++) {
            System.out.println(stack.pop());
        } // 9 ~ 0
    }
}
