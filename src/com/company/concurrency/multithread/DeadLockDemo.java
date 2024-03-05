package com.company.concurrency.multithread;

/**
 * @author Administrator
 */
public class DeadLockDemo {

    public static Object lockA = new Object();
    public static Object lockB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lockA) {
                    System.out.println("Thread 1 holding lockA...");
                    try { Thread.sleep(10); }
                    catch (InterruptedException e) {}
                    synchronized (lockB) {
                        System.out.println("Thread 1 holding lockA and lockB...");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lockB) {
                    System.out.println("Thread 2 holding lockB...");
                    try { Thread.sleep(10); }
                    catch (InterruptedException e) {}
                    synchronized (lockA) {
                        System.out.println("Thread 2 holding lockB and lockA...");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
