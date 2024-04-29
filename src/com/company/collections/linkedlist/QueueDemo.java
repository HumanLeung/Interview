package com.company.collections.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Administrator
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        queue.offer("five");
        queue.offer("six");
        System.out.println(queue);

        String str = queue.poll();
        //one
        System.out.println(str);
        System.out.println(queue);

        System.out.println("遍历开始");
        //倒着写，queue.size()会随着每次poll取数而改变
        for(int i=queue.size();i>0;i--){
            str = queue.poll();
            //元素：two   元素：three   元素：four   元素：five   元素：six
            System.out.print("元素："+str+"   ");
        }
        System.out.println();

        System.out.println("遍历结束");
        //[]
        System.out.println(queue);
    }
}
