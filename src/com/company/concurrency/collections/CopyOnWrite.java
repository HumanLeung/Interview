package com.company.concurrency.collections;

public class CopyOnWrite {

    public static void main(String[] args) {
       ConcurrentArray concurrentArray = new ConcurrentArray();
       concurrentArray.simulate();
    }
}
// ArrayList modification
// 导致原因
// 解决方案
// 优化建议
// Vector 并发低
// private transient volatile Object[] array;