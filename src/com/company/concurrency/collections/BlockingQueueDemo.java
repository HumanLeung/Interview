package com.company.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
/**
 *
 * 	BlockingQueue -> an interface that represents a queue that is thread safe
 * 		Put items or take items from it ...
 *
 * 		For example: one thread putting items into the queue and another thread taking items from it
 * 			at the same time !!!
 * 				We can do it with producer-consumer pattern !!!
 *
 * 		put() putting items to the queue
 * 		take() taking items from the queue
 *
 * @author Administrator
 */

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        FirstWorker firstWorker = new FirstWorker(queue);
        SecondWorker secondWorker = new SecondWorker(queue);
        new Thread(firstWorker).start();
        Thread.sleep(5000);
        new Thread(secondWorker).start(); }
}
class FirstWorker implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;
    public FirstWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
        int counter = 0;
        while (true) {
          try {
           blockingQueue.put(counter);
           System.out.println("put item to the queue " + counter);
           counter++;
           Thread.sleep(10);
         } catch (InterruptedException e) {
           e.printStackTrace();
       }
     }
    }
}
class SecondWorker implements Runnable {
    private final BlockingQueue<Integer> blockingQueue;
    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public void run() {
      while (true) {
          try {
              System.out.println("get item from queue " + blockingQueue.take());
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
    }
}
