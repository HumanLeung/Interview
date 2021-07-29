package com.company.concurrency.threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Spinlock {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in hello");
        while(!atomicReference.compareAndSet(null,thread)){
            System.out.println("hello");
        }
    }
    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnlock()");
    }
    public static void main(String[] args) throws InterruptedException {
   Spinlock spinlock = new Spinlock();
   new Thread(() -> {
       try {
           spinlock.myLock();
           TimeUnit.SECONDS.sleep(5);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }finally {
           spinlock.myUnlock();
       }
   },"AA").start();
   Thread.sleep(1000);
        new Thread(() -> {
                spinlock.myLock();
//                TimeUnit.SECONDS.sleep(5);
                spinlock.myUnlock();
        },"BB").start();
    }
}
//spinlock
//是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，
//这样的好处是减少线程上下切换的消耗，缺点是循环会消耗CPU


//独占锁(写锁)共享锁(读锁)/互斥锁
//该锁一次只能被一个线程所持有，对ReentrantLock和synchronized而言都是独占锁

//共享锁:指该锁可被多个线程持有.
//ReentrantReadWriteLock其读锁是共享锁，其写锁是独占锁
