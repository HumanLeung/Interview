package com.company.concurrency.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndReentrant {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t1.join();

        t2.start();
        t2.join();
    }}
class Worker {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void producer () throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        condition.await();
        System.out.println("Producer again...");
        lock.unlock();
        System.out.println("this is producer unlock");
    }
    public void consume () throws InterruptedException {
        lock.lock();
        System.out.println("this is sleep");
        Thread.sleep(2000);
        System.out.println("Consumer method...");
        condition.signal();
        System.out.println("this is condition signal");
        lock.unlock();
        System.out.println("this is consume unlock");
        System.out.println("this is consume finished");
    }
}
