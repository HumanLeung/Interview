package com.company.concurrency.cas;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User john = new User("john",12);
        User susan = new User("susan",14);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(john);
        atomicReference.compareAndSet(john,susan);
        // Timestamp atomicReference
        //解决ABA问题??? 理解原子引用 + 新增一种机制， 那就是Timestamp或者版本号
        //T1 100 1   T2 100
        //T1 101 2
        //T1 100 3   T2 100 1
    }
}
