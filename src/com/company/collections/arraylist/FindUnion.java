package com.company.collections.arraylist;

import java.util.ArrayList;

/**
 * @author Administrator
 */
public class FindUnion {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(2);
        arrayList1.add(4);

        ArrayList<Integer> union = new ArrayList<>(arrayList1);

        union.retainAll(arrayList);

        System.out.println(union);
    }
}
