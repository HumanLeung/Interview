package com.company.concurrency.semaphore;

import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class BlockingThreadPoolExecutor extends ThreadPoolExecutor {

    private final Semaphore semaphore;
    public BlockingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                      TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        semaphore = new Semaphore(corePoolSize);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
    }

    public void execute(final Runnable task) {
        boolean acquired = false;
        do {
            try {
                semaphore.acquire();
                acquired = true;
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        } while (!acquired);

        try {
            super.execute(task);
        } catch (final RejectedExecutionException e) {
            e.printStackTrace();
            semaphore.release();
        }
        semaphore.release();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null){
            t.printStackTrace();
        }

    }
}
