package com.company.concurrency.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LiveLock liveLock = new LiveLock();
        Thread worker1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    liveLock.worker1();
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
                    liveLock.worker2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        worker1.start();
        worker2.start();
    }
    public void worker1() throws InterruptedException {
        while (true){
            try {
                System.out.println("lock1 is trying to lock");
                lock1.tryLock(5000, TimeUnit.MILLISECONDS);
                System.out.println("lock1 is not working");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker1 acquires the lock1...");
            System.out.println("Worker1 trying to get lock2...");

            boolean result = lock2.tryLock();
            System.out.println(result);
            if (result) {
                System.out.println("Worker1 acquires the lock2...");
                lock2.unlock();
            } else {
                System.out.println("Worker1 can not acquire lock2...");
                continue;
            }
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }
    public void worker2() throws InterruptedException {
        while (true){
            try {
                System.out.println("lock2 is trying to lock");
                lock2.tryLock(5000, TimeUnit.MILLISECONDS);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker2 acquires the lock2...");
            System.out.println("Worker2 trying to get lock1...");

            if (lock1.tryLock()) {
                System.out.println("Worker2 acquires the lock1...");
                lock1.unlock();
            } else {
                System.out.println("Worker2 can not acquire lock1...");
                continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }

}
