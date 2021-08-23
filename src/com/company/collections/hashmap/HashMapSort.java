package com.company.collections.hashmap;

import java.util.*;

public class HashMapSort {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("dd",11);
        map.put("ee",55);
        map.put("ff",66);
        map.put("aa",33);
        map.put("bb",44);

        System.out.println("Before Sorting the Map:");
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> me = iterator.next();
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }

        Map<String, Integer> treeMap = new TreeMap<>(map);
        System.out.println("After Sorting HashMap:");
        Set<Map.Entry<String,Integer>> set2 = treeMap.entrySet();
        for (Map.Entry<String, Integer> stringIntegerEntry : set2) {
            System.out.print(stringIntegerEntry.getKey() + ":");
            System.out.println(stringIntegerEntry.getValue());
        }
    }
}
