package com.company.ch03.se03.p03;

/**
 * 메소드 재정의(Method Overriding)
 * Override -> 덮어 씌운다. 해킹해서 뭔가 달라지게 한다.
 * 다형성(polymorphism)의 근간이 됩니다.
 */

class Person{
    public void writeCode() {
        System.out.println("아무 코드나 일단 적어 보았다");
    }
}

class Student extends Person {
    @Override //이렇게 적어 주는 것이 관례, 필수는 아님(문법 오류는 아님)
    public void writeCode() {
        System.out.println("능숙하게 코드를 작성해 보았다.");
        System.out.println("답은 틀렸다.");
        System.out.println("하지만 무언가 또 배웠다.");
    }

    public void sleep() {
        System.out.println("잘잤다");
    }
}

class Developer extends Person{
    @Override
    public void writeCode(){
        System.out.println("능숙하게 코드를 작성해 보았다.");
        System.out.println("아무 코드나 일단 적어 보았다");
        System.out.println("코드가 작성하기 싫어서 하지 않았다");
    }

}
public class Overriding {
    public static void main(String[] args) {
        Student stud = new Student();
        stud.writeCode();

        Person person = new Person();
        person.writeCode();

        Developer dev = new Developer();
        dev.writeCode();

        Person p = (Person)dev; // 부모클래스 자료형으로 자식 클래스를 받을 수 있다.
        p.writeCode(); // 부모 클래스 자료형이지만 오버라이드된 메소드가 동작한다.
        p = (Person)stud;
        p.writeCode();
        // 다형성(Polymorphism)의 구현 중 하나이다.


        Person[] people = new Person[]{new Developer(), new Student()};
        for (Person person1 : people){
            person1.writeCode();
        }

        stud.sleep();
        p = (Person)stud;
//        p.sleep();
        // 부모 클래스로 캐스팅이 되면, 자식 클래스에만 잇는 메소드는 실행이 안된다.
    }
}
