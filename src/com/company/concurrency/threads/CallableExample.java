package com.company.concurrency.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 */
public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer>[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++){
            Callable<Integer> callable = new CallableDemo();
            randomNumberTasks[i] = new FutureTask(callable);
            Thread thread = new Thread(randomNumberTasks[i]);
            thread.start();
        }
        for (int i = 0; i < 5; i++) {
            // As it implements Future, we can call get()
            System.out.println(randomNumberTasks[i].get());
        }
    }

}
class CallableDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random generator = new Random();
        int randomNumber = generator.nextInt(5);
        Thread.sleep(randomNumber * 1000L);
        return randomNumber;
    }
}
