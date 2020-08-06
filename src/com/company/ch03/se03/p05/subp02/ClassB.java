package com.company.ch03.se03.p05.subp02;


import com.company.ch03.se03.p05.subp01.ClassA;
import org.w3c.dom.ls.LSOutput;

class ClassAA extends ClassA {
    public void methodTest() {
        System.out.println(x); //public
        System.out.println(y); //protected 자식이면 다른 패키지여도 ok
        // protected는 private처럼 쓰지만, 상속한 경우 구현 시 접근이 필요할 때
//        System.out.println(z); // default
//        System.out.println(w); // private

        methodA(); //public
        methodB(); //protected
//        methodC(); //default
//        methodD(); //private
    }
}
public class ClassB {
    public static void main(String[] args) {
        ClassA obj = new ClassA();
        System.out.println(obj.x); // public
//        System.out.println(obj.y);
//        System.out.println(obj.z);
//        System.out.println(obj.w);

        obj.methodA();
//        obj.methodB();
//        obj.methodC();
//        obj.methodD();
    }

}
