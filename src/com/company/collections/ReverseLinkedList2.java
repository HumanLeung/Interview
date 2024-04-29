package com.company.collections;

import java.util.LinkedList;

/**
 * @author Administrator
 */
public class ReverseLinkedList2 {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("Physics");
        ll.add("Maths");
        ll.add("Java");
        ll.add("English");
        ll.add("Chemistry");
        System.out.println("The elements of the linked list before reversing: " + ll);
        // Calling user defined function for reversing
        ll = reverseLinkedList(ll);
        System.out.println("The elements of the linked list after reversing: " + ll);
    }
    //Takes a linklist as a parameter and returns a reversed linked list
    public static LinkedList<String> reverseLinkedList(LinkedList<String> ll) {
        for (int i = 0; i < ll.size() / 2; i++) {
            String temp = ll.get(i);
            ll.set(i, ll.get(ll.size() - i - 1));
            ll.set(ll.size() - i - 1, temp);
        }
        // Return the reversed arraylist
        return ll;
    }
}
