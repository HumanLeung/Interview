package com.company.concurrency.collections;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * Latch --> multiple threads can wait for each other
 *
 * A CyclicBarrier is used in situations where you want to create a group of
 * tasks to perform work in parallel + wait until they are all finished before
 * moving on to the next step -> something like join() -> something like
 * CountDownLatch
 *
 * CountDownLatch: one-shot event CyclicBarrier: it can be reused over and over
 * again
 *
 * + cyclicBarrier has a barrier action: a runnable, that will run automatically
 * when the count reaches 0 !!
 *
 * new CyclicBarrier(N) -> N threads will wait for each other
 *
 * WE CAN NOT REUSE LATCHES BUT WE CAN REUSE CyclicBarriers --> reset() !!!
 *
 * @author Administrator
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, ()
                -> System.out.println("We are able to use the trained neural network..."));
        for(int i=0; i < 5; ++i) {
            executorService.execute(new Worker3(i + 1, barrier));
        }
        executorService.shutdown();
    }
}

class Worker3 implements Runnable {
    private final int id;
    private final CyclicBarrier cyclicBarrier;
    public Worker3(int id, CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }
    @Override
    public void run() {
       doWork();
    }
    private void doWork() {
        System.out.println("Thread with ID " + id + " starts the task...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with ID " + id + " finished...");
        try {
            System.out.println(cyclicBarrier.getNumberWaiting() + " this is waiting");
            cyclicBarrier.await();
            System.out.println("After await...");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
    public String toString() { return ""+this.id; };
}
