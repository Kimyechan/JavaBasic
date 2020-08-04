package com.company.ch03.se01;

/**
 * 초기화 블록(Initializer)
 */
public class Initializer {
    static int classVar;
    static int instanceCount;
    int instanceVar;

    // static initializer
    static {
        System.out.println("static block1");
        classVar = 20;
    }

    // object initializer
    {
        System.out.println("block1");
        instanceVar = 30;
        classVar = 50; // 추천되지 않는다.
        instanceCount++; // 이러한 패턴은 사용
    }

    static {
        System.out.println("static block2");
        classVar = 5;
    }

    {
        System.out.println("block2");
        instanceVar = 5;
    }
}

class MainTestA{
    public static void main(String[] args) {
        System.out.println(Initializer.classVar);
        Initializer main = new Initializer();
        System.out.println(Initializer.instanceCount);
        System.out.println(main.instanceVar);
        System.out.println(Initializer.classVar);
        Initializer main2 = new Initializer();
        System.out.println(Initializer.instanceCount);
        Initializer main3 = new Initializer();
        System.out.println(Initializer.instanceCount);
    }
}