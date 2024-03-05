package com.company.concurrency.future;

import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class Demo01 {

    static ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
            50,
            10,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {
        System.out.println("Main Thread start...");
         CompletableFuture.runAsync(() -> {
             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                 e.printStackTrace();
             }
             System.out.println("thread-1..." + Thread.currentThread().getName());
         }, executor);
        System.out.println("Main Thread end...");
        executor.shutdown();
    }
}
