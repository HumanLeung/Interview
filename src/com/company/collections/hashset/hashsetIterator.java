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
        Iterator<String> i = h.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
