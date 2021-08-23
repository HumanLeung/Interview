package com.company.concurrency.executor;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class ScheduledThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        StockMarketUpdater stockMarketUpdater = new StockMarketUpdater();
       ScheduledFuture<?> handler = executorService.scheduleAtFixedRate(stockMarketUpdater,
                0,2000, TimeUnit.MILLISECONDS);
       executorService.scheduleAtFixedRate(stockMarketUpdater,1000,2000,TimeUnit.MILLISECONDS);

        System.out.println(handler.get());
    }
}
class StockMarketUpdater implements Runnable {
   final Object object = new Object();

    int num = 0;
    @SneakyThrows
    @Override
    public void run() {
        synchronized (object){
            System.out.println(++num);
            Thread.sleep(2000);
            System.out.println("Sleep done"+ Thread.currentThread().getName());
        }
    }
}
// 它的主要特点为: 线程复用: 控制最大并发数： 管理线程.
// 降低资源消耗, 通过重复利用已创建的线程降低线程创建和销毁造成的消耗
// 提高响应速度. 当任务到达时，任务可以不需要的等到线程创建就能立即执行。
// 提高线程的客观理性.线程时稀缺资源，如果无限制的创建，不仅会消耗系统资源，
//还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控
//Executor,
//Executors
//ExecutorService
//AbstractExecutorService
//ScheduledExecutorService
//ThreadPoolExecutor
//Executors.newWorkStealingPool()
//Executors.newFixedThreadPool --执行长期的任务
//Executors.newSingleThreadExecutor -- LinkedBlockingQueue<Runnable> --一个任务一个任务执行
//Executors.newCachedThreadPool -- SynchronousQueue -- 适用: 执行很多异步短期任务的小程序

//Executors.newFixedThreadPool
//主要特点如下:
//1. 创建一个定长线程池, 可控制线程最大并发数，超出线程会在队列等待>
//2. newFixedThreadPool创建的线程corePoolSize和maximumPoolSize值
//是相等的,它使用的LinkedBlockingQueue;
//int corePoolSize: 线程池中的常驻核心线程数
//int maximumPoolSize: 线程池能够容纳同时执行的最大线程数，此值必须大于等于1
//long keepAliveTimeL: 多余的空闲线程的存活时间.
//当前线程池数量超过corePoolSize时，当空闲时间达到keepAliveTime值时，
//多余空闲线程会被销毁知道只剩下corePoolSize个线程为止
//TimeUnit unit keepAliveTime的单位。
//BlockingQueue workQueue 任务队列，被提交但尚未被执行的任务。
//ThreadFactory threadFactory: 表示生成线程池池中工作线程的线程工厂，用于创建线程一般用默认线程
//RejectedExecutionHandler defaultHandler: 拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程数
//(maximumPoolSize)时如何来拒绝请求执行的runnable的策略

// workflow
//1. 在创建了线程池后,等待提交过来的任务请求。
//        2. 当调用execute()方法添加一个请求任务时,线程池会做如下判断:
//        2.1 如果正在运行的线程数量小于corePoolSize,那么马上创建线程运行这个任务;
//        2.2 如果正在运行的线程数量大于或等于 corePoolSize,那么将这个任务放入队列;
//        2.3 如果这时候队列满了且正在运行的线程数量还小于maximumPoolSize,那么还是要创建非核心线程立刻运行这个任务;
//        2.4 如果队列满了且正在运行的线程数量大于或等于maximumPoolSize,那么线程池会启动饱和拒绝策略来执行。
//        3. 当一个线程完成任务时,它会从队列中取下一个任务来执行。
//        4. 当一个线程无事可做超过一定的时间(keepAliveTime)时,线程池会判断:
//        如果当前运行的线程数大于corePoolSize,那么这个线程就被停掉。
//        所以线程池的所有任务完成后它最终会收缩到corePoolSize 的大小。

// AbortPolicy(default): 直接抛出RejectedExecutionException异常阻止系统正常运行.
// CallerRunsPolicy: "调用者运行
//一种调节机制， 该策略即不会抛弃任务，也不会抛出异常，
// 而是将某些任务回退掉调用者，从而降低新任务的流量。
// DiscardOldestPolicy：抛弃队列中等待最久的任务, 然后把当前任务加入队列中尝试再次提交
// 当前任务。
// DiscardPolicy: 直接丢弃任务， 不予任何处理也不抛出异常。如果允许任务丢失
// 这是最好的一种方案