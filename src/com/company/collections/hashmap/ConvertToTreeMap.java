package com.company.collections.hashmap;

import java.util.*;

public class ConvertToTreeMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("B","john");
        map.put("C","anne");
        map.put("A","Linda");

        Map<String, String> treeMap = new TreeMap<>(Collections.reverseOrder());
        treeMap.putAll(map);

        for (Map.Entry<String,String> mapElement : treeMap.entrySet()) {
            String key = mapElement.getKey();
            // Add some bonus marks
            // to all the students and print it
            String value = mapElement.getValue();

            System.out.println(key + " : " + value);
        }
        new LinkedHashMap<>().toString();

    }

}
