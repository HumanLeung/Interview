package com.company.concurrency.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoresDemo {
    static int i;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(i=0;i<10;i++) {
            executorService.execute(new Runnable() {
                public void run() {
                    Downloader.INSTANCE.downloadData();
                }
            });
        }
        executorService.shutdown();
        System.out.println("it is done");
    }
}
enum Downloader {
    INSTANCE;
    private final Semaphore semaphore = new Semaphore(5, true);
    public void downloadData() {
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("releasing....");
        }
    }
    private void download() {
        System.out.println("Downloading data from the web... ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
