package com.company.concurrency.multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread worker1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.worker1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        worker1.setName("worker1");
        Thread worker2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.worker2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        worker1.start();
        worker2.start();


    }
    public void worker1() throws InterruptedException {
        lock1.lock();
        System.out.println("Worker1 acquires the lock1...");
        Thread.sleep(300);
        System.out.println("worker1 is trying to take a lock lock2");
        lock2.lock();
        System.out.println("Worker1 acquired the lock2...");
        lock1.unlock();
        System.out.println("lock1 is unlocked");
        lock2.unlock();
        System.out.println("lock2 is unlocked");

    }
    public void worker2() throws InterruptedException {
        System.out.println("lock1 is trying to take a lock from work2");
        lock1.lock();
        System.out.println("Worker2 acquires the lock1...");
//        Thread.sleep(300);
        System.out.println("sleeping finished");
        lock2.lock();
        System.out.println("Worker2 acquired the lock1...");
        lock1.unlock();
        lock2.unlock();
    }
}
