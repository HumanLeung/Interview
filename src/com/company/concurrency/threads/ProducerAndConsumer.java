package com.company.concurrency.threads;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Process2 process = new Process2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
class Process2 {
    private final List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;
    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size()==UPPER_LIMIT) {
                    System.out.println("Waiting for removing items...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Adding "+ value);
                    list.add(value);
                    value++;
                    // we can call the notify - because the other thread will be
                    // notified only when it is in waiting state
                    lock.notify();
                }
                Thread.sleep(600);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    value = 0;
                    System.out.println("Waiting for adding items...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Removing "+ list.remove(list.size()-1));
                    lock.notify();
                    // do other operations
                }
                Thread.sleep(600);
            }
        }
    }
}

