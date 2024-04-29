package com.company.concurrency.executor;

import com.company.exception.BusinessException;

import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        try {
            for (int i = 0; i < 20; i++) {
                int finalI = i;
                threadPool.execute(() -> {
                    Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("我们自定义的线程异常处理器"));
                    if (finalI == 10){
                        throw new BusinessException("sub-thread");
                    }
                    System.out.println(Thread.currentThread().getName()+"\t working");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e) {
            System.out.println("thread-" + e.getMessage());
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
