package com.company.concurrency.threads;

public class CustomObject {
    public static int counter1= 0;
    public static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void increment1() {
        // at the same time != parallel -CPU Time slicing
        synchronized (lock1) {
            counter1++;
        }
    }
    public static void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }
    public static void process() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                increment1();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                increment2();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(counter2);
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        process();
    }

}
