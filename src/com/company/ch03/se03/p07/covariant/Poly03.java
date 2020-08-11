package com.company.ch03.se03.p07.covariant;

import org.w3c.dom.ls.LSOutput;

/**
 * 공변 반환 타입(Covariant return type)
 */

class Foo{
    public Foo getInstance() {
//        System.out.println("Foo");
        return this;
    }

    public void methodA() {
        System.out.println("aaaaa");
    }

    public String AAA(){
        return "Foo";
    }
}

class Bar extends Foo {
    @Override
    public Bar getInstance(){ // 오버라이딩이지만, 리턴 타입이 달라질 수 있다.
//        System.out.println("Bar");
        return this;
    }

    public void methodB(){
        System.out.println("bbbbb");
    }

    public String AAA(){
        return "Bar";
    }
}
public class Poly03 {
    public static void main(String[] args) {
        Foo fooBar = new Bar();
        Foo newFoo = fooBar.getInstance();
        Bar newBar = (Bar)fooBar.getInstance();


        fooBar.methodA();
//        fooBar.methodB();
        newFoo.methodA();
//        newFoo.methodB();
        newBar.methodA();
        newBar.methodB();
        System.out.println(fooBar);
        System.out.println(newBar);
    }

}
