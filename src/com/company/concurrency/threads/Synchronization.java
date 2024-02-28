package com.company.concurrency.threads;

/**
 * @author Administrator
 */
public class Synchronization {

    public static int counter = 0;
    public static int counter2 = 0;
    /** we have to make sure this method is called only by a single thread
     at a given time
     usually it is not a good practice to use synchronized keyword
     */
    public static synchronized void increment() {
        counter++;
    }
    public static void increment2() {
            counter2++;
    }
    public static void process() {
        Thread t1 = new Thread(() -> {
           for (int i = 0; i < 100; ++i) {
               synchronized (Synchronization.class) {
                   increment2();
               }
           }
            System.out.println(Thread.currentThread().getName());
            System.out.println(counter2);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                synchronized (Synchronization.class) {
                    increment2();
                }
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println(counter2);
        });
        t1.start();
        t2.start();
        System.out.println("The counter is: "+ counter2);
    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-----"+"主线程");
        process();
    }
}
