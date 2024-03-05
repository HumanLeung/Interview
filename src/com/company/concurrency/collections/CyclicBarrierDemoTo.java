package com.company.concurrency.collections;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Administrator
 */
public class CyclicBarrierDemoTo {
    public static class Soldier implements Runnable{
        private final String solider;
        private final Random random = new Random();
        private final CyclicBarrier cyclicBarrier;

        Soldier(CyclicBarrier cyclicBarrier, String soliderName){
            this.cyclicBarrier = cyclicBarrier;
            this.solider = soliderName;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

        }
        void doWork(){
            try {
                Thread.sleep(Math.abs(random.nextInt() % 10000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println(solider + ":任务完成");
        }
    }
    public static class BarrierRun implements Runnable{
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int N){
            this.flag = flag;
            this.N = N;
        }
        @Override
        public void run() {
               if (flag) {
                   System.out.println("司令:[士兵" + N + "个，任务完成！]");
               } else {
                   System.out.println("司令:[士兵" + N + "个，集合完毕！]");
                   flag = true;
               }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        //设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for (int i = 0; i < N; ++i) {
            System.out.println("士兵 " + i + " 报道！");
            allSoldier[i] = new Thread(new Soldier(cyclic, "士兵 " + i));
            allSoldier[i].start();
        }
    }
}
