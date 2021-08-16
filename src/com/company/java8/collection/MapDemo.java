package com.company.java8.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapDemo {

    private static final Map<String, Employee> map1 = new HashMap<>();
    private static final Map<String, Employee> map2 = new HashMap<>();

    public static void main(String[] args) {
        Employee employee1 = new Employee(1L, "Henry");
        map1.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map1.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map1.put(employee3.getName(), employee3);

        Employee employee4 = new Employee(2L, "George");
        map2.put(employee4.getName(), employee4);
        Employee employee5 = new Employee(3L, "Henry");
        map2.put(employee5.getName(), employee5);

        Map<String, Employee> map3 = new HashMap<>(map1);
        map2.forEach((key,value) -> map3.merge(key, value, (v1,v2)
                -> new Employee(v1.getId(), v2.getName())));

        iterateMap(map3);
        sortMap(map3);
    }

    public static void iterateMap(Map<String,Employee> map){
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }
    public static void sortMap(Map<String,Employee> map){
        // sort by keys, a,b,c..., and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
        Map<String,Employee> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        Map<String,Employee> result2 = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getId).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result);
        System.out.println(result2);
    }
}
