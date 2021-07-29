package com.company.concurrency.threads;
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // It is not parallel execution
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());
        Thread t3 = new Runner3();
        Thread t4 = new Runner4();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
    }
}
class Runner1 implements Runnable{
    public void execute() {
        for (int i=0; i<10; ++i) {
            System.out.println("Runner1: " + i);
        }
    }
    @Override
    public void run() {
      execute();
    }
}
class Runner2 implements Runnable{
    public void execute() {
        for (int i=0; i<10; ++i) {
            System.out.println("Runner2: " + i);
        }
    }
    @Override
    public void run() {
       execute();
    }
}
class Runner3 extends Thread{
    @Override
    public void run() {
        for (int i=0; i<10; ++i) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner3: " + i);
        }
    }
}
class Runner4 extends Thread{
    @Override
    public void run() {
        for (int i=0; i<10; ++i) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Runner4: " + i);
        }
    }
}
// Thread.sleep() method throws InterruptedException if a thread in sleep is
// interrupted by other threads. InterruptedException is a checked type of
// exception. That means, “Thread.sleep()” statement must be enclosed within
// try-catch blocks or it must be specified with throws clause.

