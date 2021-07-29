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
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print(me.getKey()+":");
            System.out.println(me.getValue());
        }
        Map<String, Integer> treeMap = new TreeMap<>(map);
        System.out.println("After Sorting HashMap:");
        Set set2 = treeMap.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            Map.Entry me2 = (Map.Entry)iterator2.next();
            System.out.print(me2.getKey()+":");
            System.out.println(me2.getValue());
        }
    }
}
