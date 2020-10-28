package com.company.ch05.se12.p01;
//3. Thread 클래스 상속해서 Override
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        // 1.익명 내부 클래스 사용
        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Thread");
            }
        });

        // 2. 람다식 사용
        Thread p2 = new Thread(() -> {
            while (true){

            }
//            System.out.println("Thread by lambda");
        });
        p2.start();

//        p2.join(); // sleep 없이 join으로 싱크를 맞출 수 있다. Blocking 동작
        p2.join(100); // 100ms동안 기다린 후에 강제로 동작

        p1.start();

        p1.join();

        MyThread thread = new MyThread();
        thread.start();


        //4. 구현 후 즉시 실행
        new Thread(() -> {
            System.out.println("IDEA");
        }).start(); // 이렇게 하면 join 등을 활용이 어려움

        System.out.println("Main thread ended");
    }
}
