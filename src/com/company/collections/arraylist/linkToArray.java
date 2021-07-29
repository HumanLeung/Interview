package com.company.collections.arraylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class linkToArray {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("DDDD");
        linkedList.add("VVVV");
        linkedList.add("BBBB");
        linkedList.add("GGGG");
        linkedList.add("RRRR");

        List<String> list = new ArrayList<>(linkedList);

        for (String str:list){
            System.out.println(str);
        }
    }

}
