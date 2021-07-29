package com.company.concurrency.multithread;

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
      Worker2 worker = new Worker2();
      Thread t1 = new Thread(worker);
      t1.start();
      Thread.sleep(1000);
        System.out.println("this is running now");
      worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");
    }
}

class Worker2 implements Runnable{
    private volatile boolean terminated;
    @Override
    public void run() {
        while(!terminated) {
            System.out.println("Working class is running...");
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}
