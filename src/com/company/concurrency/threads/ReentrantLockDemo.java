package com.company.concurrency.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        },"t1").start();

     new Thread(() -> {
         phone.sendSMS();
     },"t2").start();

     Thread t3 = new Thread(phone,"t3");
     Thread t4 = new Thread(phone,"t4");
     t3.start();
     t4.start();

    }
}
class Phone implements Runnable{
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getId()+"\t invoked sendSMS()");
         sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId()+"\t #####invoked sendEmail()");
    }

Lock lock = new ReentrantLock();
    @Override
    public void run() {
       getTest();
    }
    public void getTest(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t invoked get()");
            setTest();
        }finally {
            lock.unlock();
        }
    }
    public void setTest(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"\t ######invoked set()");
        }finally {
            lock.unlock();
        }
    }
}
// 可重入锁
//指的是同一线程外层函数获得锁之后， 内层递归函数仍然能获取改锁的代码，
//在同一个线程在外层方法获取锁的时候，在进入内存方法会自动获取锁
//也即是说，线程可以进入任何一个它以及拥有锁的额同步代码块


//t1 invoked sendSMS() t1线程在外层方法获取锁的时候
//t1 ########invoked sendEmail() t1在进入内存方法会自动获取锁

//t2 invoked sendSMS()
//t2 #######invoked sendEmail()

//* 题目: Synchronized Lock有什么区?用新lock 有什么好处?你举例说说
//        * 1原始构成
//        Synchronized是关键字高于JVM层面, ,
//        monitorenter(底层是通过monitor 对象来完成,其实wait/notify等方法也依赖于monitor对象只有在同步块或方法中
//        才能调wait/notify等方法
//        monitorexit
//        Lock 是具体类(java.util.concurrent. Locks. Lock)是opi层面的
//        2 使用方法
//synchronized 不需要用户去手动释放锁,synchronized 代码执行完后系统会自动让线释放对錢的占用
//        ReentrantLock则需要用户去手动释放锁若没有主动释放锁,就有可能导致出现死锁现象。
//        而要lock()FunLock()方法虚try/final Ly语句块来完成。
//        3 等待是否可中断
//synchronized 不可中断,除非她出异常或者正常运行完成
//        RentrantLock 可中断,1. 设置超时方法 tryLock(Long timeout, Timeunit unit)
//        2. LockInterruptibly()就代码块中,调用interrupt()方法可中断
//        4 如被是不公平
//synchronized A VE
//        Reentrantlock两者都可以,以非公平锁,构造方法可以传入boolean 值,true 公平锁,false 为非公平锁
//        5 筑物定多个条件ondition
//synchronized
//ReentrantLock用来实现分组唤醒需要喚醒的线程们,可以精确峻程,而不是像Synchronized 要怎麼机唤醒一个线程要么难全部戈程。




