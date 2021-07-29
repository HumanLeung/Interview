package com.company.concurrency.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentArray {
    private final List<Integer> list;

    public ConcurrentArray() {
        this.list = new CopyOnWriteArrayList<>();
        this.list.addAll(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
    }
    public void simulate() {
        Thread t1 = new Thread(new WriteTask(list));
        Thread t2 = new Thread(new WriteTask(list));
        Thread t3 = new Thread(new WriteTask(list));
        Thread t4 = new Thread(new ReadTask(list));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class WriteTask implements Runnable {
    private final List<Integer> list;
    private final Random random;

    public WriteTask(List<Integer> list) {
        this.list = list;
        this.random = new Random();
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.set(random.nextInt(list.size()),random.nextInt(10));
        }
    }
}
class ReadTask implements Runnable {
    private final List<Integer> list;

    public ReadTask(List<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        while(true) {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(list);
        }
    }
}
