package com.company.collections.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 */
public class DelayQueueDemo {

    static class DelayedElement implements Delayed{
        private final long startTime;
        private final long delayTime;
        private final String message;

        public DelayedElement(long delay, String message){
            this.startTime = System.currentTimeMillis();
            this.delayTime = delay;
            this.message = message;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            long diff = startTime + delayTime - System.currentTimeMillis();
            return unit.convert(diff,TimeUnit.MILLISECONDS);
        }

        @Override
        public String toString() {
            return message;
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.startTime + this.delayTime, ((DelayedElement) o).startTime + ((DelayedElement) o).delayTime);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();

        // 添加延迟元素，例如5秒后过期
        delayQueue.put(new DelayedElement(5000, "Message 1"));
        delayQueue.put(new DelayedElement(10000, "Message 2"));
        delayQueue.put(new DelayedElement(6000, "Message 3"));


        while (!delayQueue.isEmpty()) {
            // 阻塞直到有元素到期
            DelayedElement element = delayQueue.take();
            System.out.println("Received: " + element);
        }
    }
}
