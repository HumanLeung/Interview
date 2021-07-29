package com.company.concurrency.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
      MyCache myCache = new MyCache();
        for (int i = 1; i <=5 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    myCache.putWrite(tempInt +"",tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <=5 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    myCache.getWrite(tempInt +"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}

class MyCache {
    private volatile Map<String,Object> map = new HashMap<>();
    private final ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
    public void putWrite(String key, Object value) throws InterruptedException {

        writeLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t writing "+
                    key);
        Thread.sleep(300);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t write finished "+
                    key);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.writeLock().unlock();
        }
    }

    public void getWrite(String key) throws InterruptedException {
      writeLock.readLock().lock();
      try{
          System.out.println(Thread.currentThread().getName()+"\t reading "+
                  key);
        Thread.sleep(300);
          Object result  = map.get(key);
          System.out.println(Thread.currentThread().getName()+"\t read finished "+
                  result);
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          writeLock.readLock().unlock();
      }
    }

    public void clearMap() {
        map.clear();
    }
}
// 读-读能共存
// 读-写不能共存
// 写-写不能共存

// 写操作:原子独占 整个过程必须是一个完整的统一体，中间不许被分割，被打断
