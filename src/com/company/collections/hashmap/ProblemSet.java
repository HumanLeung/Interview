package com.company.collections.hashmap;

import java.util.*;

/**
 * @author Administrator
 */
public class ProblemSet {
    public static void main(String[] args) {
        Hashtable<String,String> hashtable = new Hashtable<>();
        hashtable.put("1","hash");
        hashtable.put("2","qwekqw");
        System.out.println(converHashTableToHashMap(hashtable));
    }

    public static <T,K> HashMap<T,K> converHashTableToHashMap(Hashtable<T,K> data){

        if (Objects.isNull(data)){
            return new HashMap<>(0);
        }

        HashMap<T,K> hashMap = new HashMap<>(data.size());
        for (Map.Entry<T, K> entry : data.entrySet()) {
            T key = entry.getKey();
            K value = entry.getValue();
            hashMap.put(key, value);
        }
        return hashMap;
    }
}
