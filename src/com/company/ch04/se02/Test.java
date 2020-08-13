package com.company.ch04.se02;

class TestParent {
    public static void testing(){
        System.out.println("testingParent");
    }
}

class TestChild extends TestParent implements TestInterface{
}

interface TestInterface {
    static void testInterface(){
        System.out.println("testInterface");
    }
}
public class Test {
    public static void main(String[] args) {
        TestParent.testing();
        TestChild.testing();
//        TestChild.testInterface();
    }
}
