package com.company.concurrency.semaphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(2);
        BlockingThreadPoolExecutor executor = new BlockingThreadPoolExecutor(1, 1,
                5000L, TimeUnit.MILLISECONDS, blockingQueue);
//        executor.prestartAllCoreThreads();
        int threadCounter = 0;

        do {
            threadCounter++;
            // Adding threads one by one
            System.out.println("Adding DemoTask : " + threadCounter);
            executor.execute(new Task(Integer.toString(threadCounter)));
//            boolean result = blockingQueue.offer(new Task(Integer.toString(threadCounter)));
//            System.out.println(result);
        } while (threadCounter != 1000);
        Thread.sleep(1000000);
    }
}
