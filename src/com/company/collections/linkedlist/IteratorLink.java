package com.company.collections.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Administrator
 */
public class IteratorLink {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Paypal");
        linkedList.add("Google");
        linkedList.add("Yahoo");
        linkedList.add("IBM");
        linkedList.add("Facebook");

        // ListIterator approach
        System.out.println("ListIterator Approach: ==========");
        for (String s : linkedList) {
            System.out.println(s);
        }

        System.out.println("\nLoop Approach: ==========");
        // Traditional for loop approach
        for (String s : linkedList) {
            System.out.println(s);
        }

        // Java8 Loop
        System.out.println("\nJava8 Approach: ==========");

        // forEach Performs the given action for each element of the Iterable until all elements have been processed or
        // the action throws an exception.
        linkedList.forEach(System.out::println);
        Object[] array = linkedList.toArray();
        String[] strArray = Arrays.copyOf(array,array.length,String[].class);
        System.out.println(Arrays.toString(strArray));
    }
}
