package com.company.concurrency.semaphore;

import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class Throttling {
    // The maximum number of tasks that can be executed
    // concurrently
    private static final int MAX_TASKS = 10;
    // The maximum number of tasks that can be queued for
    // execution
    private static final int MAX_QUEUE = 100;

    public static void main(String[] args) throws InterruptedException {
        // Create a ThreadPoolExecutor with the desired
        // settings
        ExecutorService executor = new ThreadPoolExecutor(
                MAX_TASKS, MAX_TASKS, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(MAX_QUEUE));
        // Create a Semaphore with the desired maximum
        // number of permits
        Semaphore semaphore = new Semaphore(MAX_TASKS);
        // Submit tasks to the executor, acquiring a permit
        // from the semaphore before each submission
        for (int i = 0; i < 1000; i++) {
            semaphore.acquire();
            executor.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"-working...");
                }
                finally {
                    // Release the permit when the task
                    // is finished
                    semaphore.release();
                }
            });
        }
    }
}
