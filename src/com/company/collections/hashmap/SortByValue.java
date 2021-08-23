package com.company.collections.hashmap;

import java.util.*;

public class SortByValue {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(2,"john");
        map.put(3,"anne");
        map.put(1,"linda");
        System.out.println(sortHashMapByValue(map));
    }
    public static LinkedHashMap<Integer, String> sortHashMapByValue(
            HashMap<Integer,String> passedMap) {
        List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
        List<String> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<Integer, String> sortMap = new LinkedHashMap<>();
        Iterator<String> valueIt = mapValues.iterator();
        while(valueIt.hasNext()) {
            String val = valueIt.next();
            Iterator<Integer>keyIt = mapKeys.iterator();

            while(keyIt.hasNext()) {
                Integer key = keyIt.next();
                String comp1 = passedMap.get(key);
                String comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortMap.put(key,val);
                    break;
                }
            }
        }
        return sortMap;
    }
}
