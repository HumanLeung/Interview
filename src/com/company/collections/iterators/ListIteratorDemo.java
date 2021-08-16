package com.company.collections.iterators;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
          list.add(1);
          list.add(2);
          list.add(3);
          list.add(4);
          list.add(5);
        System.out.println("Elements of ArrayList: ");
        for (Integer i : list) {
            System.out.println(i);
        }

        for (Integer integer : list) System.out.println(integer + " ");

        ListIterator<Integer> i = list.listIterator(list.size());
        while(i.hasPrevious()) System.out.println(i.previous()+ " ");

//        Collections.sort();


    }
}
