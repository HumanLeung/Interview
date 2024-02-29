package com.company.io.socket.threadpool;

import java.util.concurrent.*;

/**
 * @author Administrator
 */
public class HandleSocketServerPool {
    private final ExecutorService executorService;

    public HandleSocketServerPool(int maxThreadNum, int queueSize){
        executorService = new ThreadPoolExecutor(3, maxThreadNum,
                120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize), Executors.defaultThreadFactory());
    }

    public void execute(Runnable runnable){
        executorService.execute(runnable);
    }
}
