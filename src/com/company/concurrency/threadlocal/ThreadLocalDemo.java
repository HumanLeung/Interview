package com.company.concurrency.threadlocal;


/*
 线程隔离
 在多线程并发的场景下，每个线程中的变量都是相互独立
 线程A， 设置(变量1) 获取(变量1)
 线程B， 设置(变量2) 获取(变量2)
 // synchronization会影响效率
 */
public class ThreadLocalDemo {
    ThreadLocal<String> t1 = new ThreadLocal<>();

    private String getContent() {
        return t1.get();
    }
    private void setContent(String content) {
       if (!Thread.currentThread().getName().equals("main")){
           t1.set(content);
       }
    }
    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                demo.setContent(Thread.currentThread().getName()+"'s data ");
                System.out.println("====================");
                System.out.println(Thread.currentThread().getName()+" -----> "+ demo.getContent());
            });
            thread.setName("thread "+i);
            thread.start();
        }
    }
}
//ThreadLocal与synchronized区别
//虽然ThreadLocal模式与synchronized都用于处理多线程并发访问变量的问题,不过两者问题的
//角度和思路不同.

