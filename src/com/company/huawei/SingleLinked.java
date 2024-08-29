package com.company.huawei;

/**
 * @author Administrator
 */
public class SingleLinked {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode node = new ListNode(1,head.next);
        head.next = node;
        ListNode node2 = new ListNode(2, head.next);
        head.next = node2;
        ListNode node3 = new ListNode(3, head.next);
        head.next = node3;
        while(null != head){
            System.out.println(head.val);
            head = head.next;
        }
    }

}
