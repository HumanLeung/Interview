package com.company.collections.arraylist;

import java.util.*;

/**
 * @author Administrator
 */
public class Iterators {
    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1,2,3,4,5).iterator();
        List<Integer> list = new ArrayList<>();
        iterator.forEachRemaining(list::add);
        list.forEach(System.out::println);

//        Vector vector = new Vector();
//        vector.get()
    }
}
