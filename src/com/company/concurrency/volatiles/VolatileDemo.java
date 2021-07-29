package com.company.concurrency.volatiles;

public class VolatileDemo {
    public static void main(String[] args) {

        // volatile 不保证原子性
          MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value: "+
        myData.number);
    }
    static public void volatileTest() {
        MyData myData = new MyData();
        new Thread(() -> { System.out.println(Thread.currentThread().getName()
                +"\t come in");
            try {
                Thread.sleep(3000);
                myData.addTo60();
                System.out.println(Thread.currentThread().getName()
                        +"\t updated number value: "+myData.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        while(myData.number == 0)
        {
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}

class MyData {
   volatile int number = 0;

    public void addTo60(){
        this.number = 60;
    }
    public void addPlusPlus(){
        number++;
    }
}
//volatile是java虚拟机提供的轻量级的同步机制
//保证可见性 不保证原子性 禁止指令重排
// JMM //JAVA Memory Model是一种抽象的概念并不真实存在，它描述的是一组规则或规范
//， 通过这组规范定义了程序中各个变量的访问方式
//JMM关于同步的规定
// 1 线程解锁前， 必须把共享变量的值刷新回主内存
// 2 线程加锁前，必须读取主内存的最新值到自己的工作内存
// 3 加锁解锁是同一把锁

// 由于JVM运行程序的实体是线程,而每个线程创建时JVM
//由于JVM运行程序的实体是线程,而每个线程创建时JVM都会为其创建一个工作内存(有些地方称为栈空间,工作内存是每个线程
//的私有数据区域,而Java内存模型中规定所有变量都存储在主内存,主内存是共享内存区域,所有线程都可以访问,但线程对变量
//的操作(读取赋值等)必须在工作内存中进行,首先要移变量从主内存拷贝的自己的工作内存空间,然后对变量进行操作,操作完成
//后再将变量写回主内存,不能直接操作主内存中的变量,各个线程中的工作内存中存储着主内存中的变量副本拷贝,因此不同的线
//程间无法访问对方的工作内存,线程间的通信(传值)必须通过主内存来完成,

// volatile不保证原子性
// 2.1 原子性指的是什么意思? 不可分割，完整性，也即某个线程正在做某个
//业务时, 中间不可以被加塞或者被分割，需要整体完整，要么同时成功，要么同时失败.
// why:
//synchronized 重量级锁


