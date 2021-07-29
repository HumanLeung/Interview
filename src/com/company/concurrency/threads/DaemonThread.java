package com.company.concurrency.threads;

public class DaemonThread {
    public static void main(String[] args) {
        String name = Thread.currentThread().getName();
        System.out.println(name);

        Thread t1 = new Thread(new Worker());
        Thread t2 = new Thread(new NormalWorker());
        t1.setDaemon(true);
        System.out.println(t1.isDaemon());

//        t2.start();
        t1.start();
//        System.out.println("main is quite");

    }
}

class Worker implements Runnable {
    int d = 10;
    @Override
    public void run() {
        while (d != 0) {
            d--;
            System.out.println("Daemon Thread from a given thread...");
        }
    }
}
class NormalWorker implements Runnable {
    @Override
    public void run() {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("NormalWorker Thread from a given thread...");
    }
}
