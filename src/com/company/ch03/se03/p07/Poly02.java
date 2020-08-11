package com.company.ch03.se03.p07;

/**
 * 맴버 변수의 재정의는 선언된 객체의 타입을 따른다. (문법적으로 본다)
 * 메소드 오버라이딩은 메모리상의 객체 타입을 따른다. (실제 객체를 본다)
 *  (가상 메소드 호출: Virtual method call)
 */

class Poo {
    public String x = "Super";

    public void methodA() {
        System.out.println("Super Method");
    }
}

class Var extends Poo {
    public String x = "Sub";

    @Override
    public void methodA(){
        System.out.println("Sub Method");
    }
}
public class Poly02 {
    public static void main(String[] args) {
        Var var = new Var();
        Poo poo = (Poo)var;

        System.out.println(var.x); // Sub
        var.methodA(); // Sub Method

        System.out.println(poo.x);
        poo.methodA(); // (가상 메소드 호출: Virtual method call)
    }
}
