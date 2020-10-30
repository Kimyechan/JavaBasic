package com.company.ch05.se12.p07;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 세마포 (Semaphore)
 * 사전적 의미 : 횟대(깃발)
 * n개의 깃발을 놓고, 여러 스레드가 경쟁하도록 하는 sync 기법
 * n = 1이면, BinarySemaphore라고 하며, Lock과 유사하게 동작
 *
 */
public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        sem.release(10);
        sem.tryAcquire();
        System.out.println(sem.availablePermits());

//        try { // Blocking으로 동작
//            sem.acquire(12);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        sem.acquireUninterruptibly(); // interrupt에 반응하지 않음
        try {
            System.out.println(sem.tryAcquire(100, TimeUnit.MILLISECONDS)); // Blocking 하지 않고, 실패하면 false
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sem.release();

        System.out.println(sem.availablePermits());
    }
}
