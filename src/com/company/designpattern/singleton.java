package com.company.designpattern;

/**
 * @author Administrator
 */
public class singleton {
    private static volatile singleton instance = null;
    private singleton() {
        System.out.println(Thread.currentThread().getName()+
                " this is singleton");
    }

    //DCL Double Check Lock
    public static void getInstance(){
        if (instance == null) {
           synchronized (singleton.class)
           {
               if (instance == null)
               {
                   instance = new singleton();
               }
           }
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(singleton::getInstance,String.valueOf(i)).start();
        }

    }

}
//步骤之间数据不存在依赖关系，而且无论重排前还是后程序结果在单线程并未有改变
//因为多线程有可能会重排