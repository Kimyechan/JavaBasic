package com.company.ch04.se02.p02;

import java.util.concurrent.atomic.AtomicBoolean;

class Calculator {
    ArithmethicOperator op;

    public Calculator(ArithmethicOperator op){
        this.op = op;
    }

    public long run(long x, long y) {
        return op.operate(x, y);
    }

    public int run(int x, int y) {
        return op.operate(x, y);
    }

    public double run(double x, double y) {
        return op.operate(x, y);
    }
}

class Runner {
    public static void run(ArithmethicOperator op, int x, int y){
        System.out.println(op.operate(x, y));
    }
}
public class Main {
    public static void main(String[] args) {
        // 다형성 예(1)
        ArithmethicOperator op;
        op = new Multiply();
        System.out.println(op.operate(10, 20));

        // 다형성 예(2)
        ArithmethicOperator [] ops;

        ops = new ArithmethicOperator[]{new Add(), new Multiply()};

        for(ArithmethicOperator o : ops){
            System.out.println(o.operate(5, 2));
        }

        // 다형성 예(3)
        Calculator add = new Calculator(new Add());
        Calculator sub = new Calculator(new Subtract());

        System.out.println(add.run(10, 20));
        System.out.println(sub.run(10, 20));

        // 다형성 예(4)
        Runner.run(new Add(), 40, 50);
        Runner.run(new Divide(), 40, 50);

    }
}
