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
                    Downloader.INSTANCE.downloadData(i);
                }
            });
        }
        System.out.println("it is done");
    }
}
enum Downloader {
    INSTANCE;
    private final Semaphore semaphore = new Semaphore(5, true);
    public void downloadData(int i) {
        try {
            semaphore.acquire();
            download(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println("releasing....");
        }
    }
    private void download(int i) {
        System.out.println("Downloading data from the web... "+ i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
