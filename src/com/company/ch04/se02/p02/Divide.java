package com.company.ch04.se02.p02;

public class Divide implements ArithmethicOperator {
    @Override
    public int operate(int x, int y) {
        return x / y;
    }

    @Override
    public long operate(long x, long y) {
        return x / y;
    }

    @Override
    public double operate(double x, double y) {
        return x / y;
    }
}
