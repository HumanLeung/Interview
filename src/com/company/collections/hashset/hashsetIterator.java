package com.company.collections.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class hashsetIterator {
    public static void main(String[] args) {
        HashSet<String> h = new HashSet<String>();

        // Adding elements into HashSet usind add()
        h.add("Geeks");
        h.add("for");
        h.add("Geeks");

        // Iterating over hash set items
        for (String s : h) System.out.println(s);

        h.forEach(System.out::println);
    }
}
