package com.company.concurrency.cas;

import lombok.val;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 */
public class AtomicIntegerDemo {
    static int b = 0;
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        val t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
                b++;
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
                b++;
            }
        });
        t2.start();
        Thread.sleep(1000);
        System.out.println("a=" + atomicInteger);
        System.out.println("b=" + b);
    }
}
