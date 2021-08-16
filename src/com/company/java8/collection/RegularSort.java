package com.company.java8.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RegularSort {
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();

        Employee employee5 = new Employee(1L, "Mer");
        map.put(employee5.getName(), employee5);
        Employee employee2 = new Employee(22L, "Annie");
        map.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map.put(employee3.getName(), employee3);
        Employee employee4 = new Employee(2L, "George");
        map.put(employee4.getName(), employee4);

        TreeMap<String,Employee> treeMap = new TreeMap<>(map);


    }
}
