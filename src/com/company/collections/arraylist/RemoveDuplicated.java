package com.company.collections.arraylist;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicated {
    public static void main(String[] args) {
        // input list with duplicates
        List<Integer> list = new ArrayList<>(
                Arrays.asList(1, 10, 1, 2, 2, 3, 10, 3, 3, 4, 5, 5));

        List<Integer> newList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(newList);

        Set<Integer> set = new LinkedHashSet<>(list);
        list.clear();
        list.addAll(set);
        list.forEach(System.out::println);
    }
}
