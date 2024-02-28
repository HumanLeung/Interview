package com.company.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        // it is a single thread that will execute the tasks sequentially
        // so one after another
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(i));
        }
    }
}
class Task implements Runnable {
    private final int id;

    public Task(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Task with id " + id+" is in work - thread id: "+
                Thread.currentThread().getName());
         long duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
