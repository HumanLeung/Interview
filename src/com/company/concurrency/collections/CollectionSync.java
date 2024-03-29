package com.company.concurrency.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionSync {
    public static void main(String[] args) {
//        List<Integer> nums = new ArrayList<>();
        // add() and remove() methods are synchronized
        // intrinsic lock - not that efficient because threads
        // have to wait for each other even when the want to execute
        // independent methods (operations)
        // concurrent collections !!!
        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(() -> {
            for (int i=0; i < 1000; i++) {
                nums.add(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i < 1000; i++) {
                nums.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Size of array: "+ nums.size());
        // that could because ArrayIndexOutOfBoundsException exception duration the runtime
    }
}
