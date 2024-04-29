package com.company.collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class ProblemSet {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));

        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "e", "f"));

        ArrayList<String> originalList = new ArrayList<>(Arrays.asList("a", "b", "c"));

        ArrayList<String> equalList = new ArrayList<>(Arrays.asList("c", "b", "a"));

        swapTwoElementsInCollections(list);

        System.out.println(compareAndFindAdditionalItems(listOne, listTwo));

        System.out.println(compareAndFindAdditionalItemsInStream(listOne, listTwo));

        System.out.println(compareAndFindMissingItems(listOne, listTwo));

        System.out.println(compareAndFindCommonItems(listOne, listTwo));

        System.out.println(compareAndFindCommonItemsInStream(listOne, listTwo));

        System.out.println(compareTwoListForEquality(originalList,equalList));
    }

    public static <T> void swapTwoElementsInCollections(List<T> list){
        Collections.swap(list,1,2);
    }

    public static <T> List<T> compareAndFindAdditionalItems(List<T> list1, List<T> list2){
       List<T> copy1 = new ArrayList<>(list1);
       List<T> copy2 = new ArrayList<>(list2);
       copy1.removeAll(copy2);
       return copy1;
    }

    public static <T> List<T> compareAndFindAdditionalItemsInStream(List<T> list1, List<T> list2){
        List<T> copy1 = new ArrayList<>(list1);
        List<T> copy2 = new ArrayList<>(list2);
        return copy1.stream().filter(item -> !copy2.contains(item)).collect(Collectors.toList());
    }

    public static <T> List<T> compareAndFindMissingItems(List<T> list1, List<T> list2){
        List<T> copy1 = new ArrayList<>(list1);
        List<T> copy2 = new ArrayList<>(list2);
        copy2.removeAll(copy1);
        return copy2;
    }

    public static<T> List<T> compareAndFindCommonItems(List<T> list1, List<T> list2){
        List<T> copy1 = new ArrayList<>(list1);
        List<T> copy2 = new ArrayList<>(list2);
        copy1.retainAll(copy2);
        return copy1;
    }

    public static<T> List<T> compareAndFindCommonItemsInStream(List<T> list1, List<T> list2){
        List<T> copy1 = new ArrayList<>(list1);
        List<T> copy2 = new ArrayList<>(list2);
        return copy1.stream().filter(copy2::contains).collect(Collectors.toList());
    }

    public static <T extends Comparable<T>> boolean compareTwoListForEquality(List<T> list1, List<T> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.equals(list2);
    }


}
