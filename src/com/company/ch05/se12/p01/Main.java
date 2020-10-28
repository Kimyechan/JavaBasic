package com.company.ch05.se12.p01;

/**
 * Multi-Thread Programming
 * 여러개의 스레드를 사용하는 프로그래밍 기법
 *
 * Thread: 최소의 프로세스 동작 단위 -> 하나의 프로세스는 여러개의 스레드를 가질 수 있다
 * Process: OS로 부터 메모리를 할당받아 동작하는 프로그램의 동작 단위
 *          프로그램이 실제로 메모리에 상주하면서 동작할 때 프로세스가 된다.
 *          - 프로그램을 실행할 때, 멀티 프로세스로 동작하는 프로그램도 있다
 *
 * 장점
 *  - 여러 동작을 병렬적으로 처리하여 CPU 사용률 향상 (CPU Utilization)
 *      - 인코딩, 랜더링, 배치작업(DB 정리, 로그 처리), ...
 *  - 시간이 걸리는 동작을 분리하여 프로그램의 응답성을 향상
 *      - GUI, 게임, 앱, 웹 API
 *
 * 단점
 *  - 디버깅이 어렵다. 쓰레드가 동시에 동작하기 때문에, 디버거로 확인하기 어려움.
 *    디버거를 쓰거나, 디버깅을 하기 위한 코드를 추가하면 동작이 변한다.
 *  - 구현이 어렵다. 쓰레드간의 동기화를 하기 위한 구현이 어렵다. 쉽게 동기화하면 느려진다.
 *      - Context Switching 오버헤드가 있기 때문에 동기화를 잘못하면 오히려 더 느려진다.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread p1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello Thread");
            }
        });

        // Thread 객체는 1회용이며, start()로 실행한다.
//        p1.run(); // 그냥 메소드 콜
        p1.start(); // 실제로 OS에 스레드 동작을 요청
//        p1.run(); // 그냥 메소드 콜이니까 다시 동작해도 잘 됨
//        p.start(); // Thread 객체는 1회용이므로 start()가 재실행 될 수 없음

        Thread p2 = new Thread(() -> {
            System.out.println("Thread by lambda");
        });
        p2.start();

        Thread.sleep(100); // Sleep을 이용해서 시간차를 줄일 수 있다.
        System.out.println("Main thread ended");
    }
}
