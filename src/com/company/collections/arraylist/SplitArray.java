package com.company.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class SplitArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Geeks");
        list.add("Practice");
        list.add("Contribute");
        list.add("IDE");
        list.add("Courses");

        List[] lists = SplitArrayList.split(list);
        System.out.println(lists[0]);
        System.out.println(lists[1]);
    }
}
class SplitArrayList {
    public static List[] split(List<String> list)
    {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        int size = list.size();

        for (int i = 0; i < size / 2; i++){
            first.add(list.get(i));
        }

        for (int i = size / 2; i < size; i++){
            second.add(list.get(i));
        }
        return new List[]{first, second};
    }
}
