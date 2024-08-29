package com.company.huawei;

/**
 * @author Administrator
 */
public class ListNode {
    Integer val;
    ListNode next = null;

    ListNode(){

    }

    ListNode(int val){
        this.val = val;
    }
    ListNode(int value, ListNode next){
        this.val = value;
        this.next = next;
    }
}
