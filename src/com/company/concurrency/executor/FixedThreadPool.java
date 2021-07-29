package com.company.concurrency.executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10000; i++) {
            executorService.execute(new Task2(i+1));
        }
        // we prevent the executor to execute any further tasls
        executorService.shutdown();
        // terminate actual (running) tasks
        try {
            if (executorService.awaitTermination(1000,TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        }catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
class Task2 implements Runnable {
    private final int id;
    public Task2(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Task with id " + id+" is in work - thread id: "+
                Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
//线程资源必须通过线程池提供，不允许在应用中自行显示创建线程.
//线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式,
// 这样的处理方式让写的同学更加明确运行规则， 规避资源耗尽的风险.
//FixedThreadPool和SingleThreadPool
//允许的请求队列长度Integer.MAX_VALUE, 可能会堆积大量的请求,从而导致OOM。
//CachedThreadPool和ScheduledThreadPool
//允许的创建线程数量为Integer。MAX.Value, 可能会创建大量的线程，从而导致BOOM
