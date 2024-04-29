package com.company.collections.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 */
public class ProblemSet {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B", "C");
        String[] stringArray;
        Object[] objArray = list.toArray();
        stringArray = list.toArray(new String[0]);
        stringArray = list.toArray(new String[0]);
        System.out.println(Arrays.toString(stringArray));
        list = Arrays.asList(stringArray);
    }
}
