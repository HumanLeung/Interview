package com.company.huawei;

/**
 * @author Administrator
 */
public class Solution {
    public static ListNode FindKthToTail(ListNode head, int k){
        if (head == null || k <= 0){
            return null;
        }

        ListNode first = head;
        ListNode second = head;

        for (int i = 1; i < k; i++){
            if (first.next != null){
                first = first.next;
            }else{
                return null;
            }
        }

        while(first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);

        ListNode node2=new ListNode(2);

        ListNode node3=new ListNode(3);

        ListNode node4=new ListNode(4);

        node1.next=node2;

        node2.next=node3;

        node3.next=node4;

        System.out.println(FindKthToTail(node1, 2).val);
    }
}
