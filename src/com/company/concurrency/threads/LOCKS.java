package com.company.concurrency.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LOCKS {
    private static int counter = 0;
    private static final Lock lock = new ReentrantLock();
    public static void increment() {
        lock.lock();
        for (int i=0; i<10000;i++) { counter++; }
        lock.unlock();
    }
    public static void add() {
        // we can also unlock here
//        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter is: " + counter);
    }
}

// 可重入锁
//指的是同一线程外层函数获得锁之后， 内层递归函数仍然能获取改锁的代码，
//在同一个线程在外层方法获取锁的时候，在进入内存方法会自动获取锁
//也即是说，线程可以进入任何一个它以及拥有锁的额同步代码块
