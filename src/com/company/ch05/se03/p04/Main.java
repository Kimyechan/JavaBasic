package com.company.ch05.se03.p04;

class LocalInnerClass {
    int x = 1;

    public Object methodA() {
        final int y1 = 2;
        int y2 = 2;

        class LocalInner { // 스택영역에 정의
            // static int z = 4; // **Impossible**
            static final int z = 4; // Possible의 // 상수풀에 저
            int w = 5;
            void methodA() {
                System.out.println(x);
                System.out.println(y1); // JDK1.7
                System.out.println(w);
                w++;
                System.out.println(y2); // JDK1.8
                //y2++; // final 처럼 사용되어야 함
            }
        }

        LocalInner inner = new LocalInner(); // Heap area
        inner.methodA();

        return (Object)inner;
    }

    static {
        int y = 2;
        class LocalInner {
            void methodA() {
                System.out.println("a");
            }
        }
    }

    {
        int y = 2;
        class LocalInner {
            void methodA() {
                System.out.println(x);
            }
        }
    }

    public static void main(String[] args) {
        int y = 2;
        class LocalInner {
            void methodA() {
                System.out.println("a");
            }
        }
    }
}

public class Main {
}
