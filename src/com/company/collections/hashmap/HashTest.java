package com.company.collections.hashmap;

import java.util.HashMap;

public class HashTest {
    public static void main(String[] args) {
        HashMap<Student,String> map2 = new HashMap<>();
        Student st2 = new Student("john","linda");
        Student st = new Student("john","linda");
        map2.put(st,"haha");
//        System.out.println(map2);
        map2.put(st2,"asd");
        System.out.println(map2);
    }
}
