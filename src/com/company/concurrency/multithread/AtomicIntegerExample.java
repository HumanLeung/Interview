package com.company.concurrency.multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
//        counter.compareAndSet()

      Thread t1 = new Thread(new Runnable() {
          @Override
          public void run() {
              System.out.println("run first");
            increment();
          }
      });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run second");
             increment();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Counter: "+counter);
    }
    public static void increment() {
        for (int i=0; i<10000; i++)
            // There is no need for synchronisation because atomic integer
            // under the hood, it uses low level synchronization
            // We can use atomic long atomic booleans atomic integer, array
         counter.getAndIncrement();
    }
}
