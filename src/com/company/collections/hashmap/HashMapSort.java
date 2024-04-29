package com.company.collections.hashmap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class HashMapSort {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("dd",11);
        map.put("ee",55);
        map.put("ff",66);
        map.put("aa",33);
        map.put("bb",44);

//        System.out.println(sortHashMapInStream(map));
        map = new LinkedHashMap<>(map);
        sortHashMap(map);
        System.out.println(map);
    }

    public static Map<String,Integer> sortHashMapInStream(Map<String,Integer> map){

        return map.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (k,v) -> k, LinkedHashMap::new));
    }

    public static void sortHashMap(Map<String,Integer> map){
        List<Map.Entry<String , Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        map.clear();
        for (Map.Entry<String,Integer> entry : list) {
            map.put(entry.getKey(),entry.getValue());
        }
    }



    public static void sortByTreeMap(Map<String,Integer> map){

        System.out.println("Before Sorting the Map:");
        Set<Map.Entry<String,Integer>> set = map.entrySet();

        for (Map.Entry<String, Integer> me : set) {
            System.out.print(me.getKey() + ":");
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
