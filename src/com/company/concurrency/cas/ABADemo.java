package com.company.concurrency.cas;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference =
            new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        new Thread(() -> {
             atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        },"t1").start();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(atomicReference.compareAndSet(100, 2019)
                +"\t"+atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
           int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第1次版本号: "+stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
                atomicStampedReference.compareAndSet(100,101,
                        atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"\t第2次版本号: "
                        +atomicStampedReference.getStamp());
                atomicStampedReference.compareAndSet(101,100,
                        atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"\t第3次版本号: "
                        +atomicStampedReference.getStamp());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t3").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第1次版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
              boolean result = atomicStampedReference.compareAndSet(100,2019,stamp, stamp + 1);
              System.out.println(Thread.currentThread().getName()+"\t result: "+result +
                     "\t Timestamp: "+ atomicStampedReference.getStamp());
                System.out.println(Thread.currentThread().getName()+"\t当前实际最新值: "
                        +atomicStampedReference.getReference());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
