package com.company.collections.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TraversalHashMap {
    public static void main(String[] args) {
//       iterator();
//        forEach();
        forEachHash();
    }
    public static void iterator() {
        // Consider the hashmap contains
        // student name and their marks
        HashMap<String, Integer> hm = new HashMap<>();
        // Adding mappings to HashMap
        hm.put("GeeksforGeeks", 54);
        hm.put("A computer portal", 80);
        hm.put("For geeks", 82);

        // Printing the HashMap
        System.out.println("Created hashmap is" + hm);

        // Getting an iterator
        Iterator<Map.Entry<String, Integer>> hmIterator = hm.entrySet().iterator();

        // Iterate through the hashmap
        // and add some bonus marks for every student
        System.out.println("HashMap after adding bonus marks:");

        while (hmIterator.hasNext()) {
            Map.Entry<String, Integer> mapElement = hmIterator.next();
            int marks = (mapElement.getValue() + 10);
            System.out.println(mapElement.getKey() + " : " + marks);
        }
    }
    public static void forEach() {
        // Consider the hashmap containing
        // student name and their marks
        HashMap<String, Integer> hm = new HashMap<>();

        // Adding mappings to HashMap
        hm.put("GeeksforGeeks", 54);
        hm.put("A computer portal", 80);
        hm.put("For geeks", 82);

        // Printing the HashMap
        System.out.println("Created hashmap is" + hm);

        // Loop through the hashmap
        System.out.println("HashMap after adding bonus marks:");

        // Using for-each loop
        for (Map.Entry<String,Integer> mapElement : hm.entrySet()) {
            String key = mapElement.getKey();

            // Add some bonus marks
            // to all the students and print it
            int value = (mapElement.getValue() + 10);

            System.out.println(key + " : " + value);
        }
    }

    static public void forEachHash() {
        // Consider the hashmap containing
        // student name and their marks
        HashMap<String, Integer> hm =
                new HashMap<String, Integer>();

        // Adding mappings to HashMap
        hm.put("GeeksforGeeks", 54);
        hm.put("A computer portal", 80);
        hm.put("For geeks", 82);

        // Printing the HashMap
        System.out.println("Created hashmap is" + hm);

        // Loop through the hashmap
        // and add bonus marks
        System.out.println("HashMap after adding bonus marks:");

        // Using Hashmap.forEach()
        hm.forEach((k, v) -> System.out.println(k + " : " + (v + 10)));
    }
}
