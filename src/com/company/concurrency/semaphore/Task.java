package com.company.concurrency.semaphore;

import com.company.exception.BusinessException;

/**
 * @author Administrator
 */
public class Task implements Runnable{

    private final String name;

    public Task(String name){
        this.name = name;
    }
    @Override
    public void run() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//            throw new BusinessException(e.getMessage());
//        }
        System.out.println(Thread.currentThread().getName()+ "-name: "+name +"- - worker is running");
    }
}
