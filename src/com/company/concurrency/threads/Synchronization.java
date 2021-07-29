package com.company.concurrency.threads;

public class Synchronization {

    public static int counter = 0;
    public static int counter2 = 0;
    // we have to make sure this method is called only by a single thread
    // at a given time
    // usually it is not a good practice to use synchronized keyword
    public static synchronized void increment() {
        counter++;
    }
    public static void increment2() {
        synchronized (Synchronization.class) {
            counter2++;
        }
    }
    public static void process() {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            int num = 1;
           for (int i = 0; i < 100; ++i) {
               increment();
           }
            System.out.println(counter);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                increment();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(counter);
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The counter is: "+ counter);
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
       process();
        System.out.println("The counter is: "+ counter);
    }
}
