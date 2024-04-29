package com.company.concurrency.executor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Administrator
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    private String name;
    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常："+t.getName(),e);
        System.out.println(name+"我捕获了异常"+t.getName()+"异常名字："+e);
    }
}
