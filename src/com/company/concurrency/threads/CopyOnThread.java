package com.company.concurrency.threads;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnThread {
    public static void main(String[] args) {
        ParallelTasks tasks = new ParallelTasks();
        File file = new File("h:\\Test");
        for (File file1 : file.listFiles()) {
            tasks.add(new CopyFileTask(file1.getAbsolutePath(),"h:\\newTest\\" + file1.getName()));
        }
        try {
            tasks.go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class ParallelTasks {
    private final Collection<Runnable> tasks = new ArrayList<>();

    public void add(final Runnable task) {
        tasks.add(task);
    }

    public void go() throws InterruptedException {
        final ExecutorService threads = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try{
            final CountDownLatch latch = new CountDownLatch(tasks.size());
            for (final Runnable task: tasks){
                threads.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            task.run();
                        }finally {
                            latch.countDown();
                        }
                    }
                });
                latch.await();
            }
        }finally {
            threads.shutdown();
        }
    }
}
