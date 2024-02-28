package com.company.concurrency.cas;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author Administrator
 */ // What is Cas ?
// compare and swap
public class CAS {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t"
        +"current data"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t"
                +"current data"+atomicInteger.get());
        // if the excepted value is equal to the original value then swap
        // 自旋锁 Unsafe
        //cas不加锁保证一致性
        //synchronization 加速并发性下架
        //AtomicInteger靠的是底层的Unsafe类
        //CAS 判断内存某个位置的值是否为预期值。如果是就更新值，这个过程是原子性的
        // 底层是连续的原子性的线程安全的

        // AtomicInteger里面的value原始值为3，即主内存中AtomicInteger的value为3, 根据JMM模型
        // 线程A和线程B各自持有一份值为3的value的副本分别到各自的工作内存。
        // 线程B也通过getIntVolatile(var1, var2)方法获取到value值3.此时刚好线程B没有被
        //挂起并且执行compareAndSwapInt比较内存值也为3.成功修改内存值为4，线程B打完收工，everything is ok
        // 这是线程A恢复, 执行compareAndSwapInt方法比较， 发现自己手里的值数字3和内存的值数字4不一致,说明该值被改了
        //，A线程本次修改失败，只能重新读取再来一遍
        // 线程A重新获取value值，因为变量value被volatile修饰，所以其它线程对它的修改，线程
        //A总是能狗看到，线程A继续执行compareAndSwapInt进行比较替换，直到成功
        //CAS(CompareAndSwap)
//      比较当前工作内存中的值和内存中的值,如果相同则执行操作,
//      否则继续比较直到内存和工作内存中的值一致为止.

        //CAS应用
        //CAS有3个操作数，内存值V，旧的预期值A，要修改的更新值B。
        //当且仅当预期值A和内存值V相同时，将内存值V修改为B
        //CAS缺点
        //如果CAS失败，会一直进行尝试。如果CAS长时间不成功，可能会给CPU带来很大的开销.
        //只能保证一个共享变量的原子操作.
        //ABA问题

//        CAS会导致“ABA问题”。
//        CAS算法实现一个重要前提需要取出内存中某时刻的数据并在当下时刻比较并替换,那么在这个时间差类会导致数据的变化。
//        比如说一个线程one从内存位置V中取出A,这时候另一个线程two也从内存中取出,并且线程two进行了一些操作将值变成了B,
//                然后线程two又将V位置的数据变成A,这时候线程one进行CAS操作发现内存中仍然是A,然后线程one操作成功。
//        尽管线程one的CAS操作成功,但是不代表这个过程就是没有问题的。
//
//        原子引用



    }
}
