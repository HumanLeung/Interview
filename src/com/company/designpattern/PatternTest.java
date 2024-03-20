package com.company.designpattern;

import com.company.designpattern.prototype.Sheep;
import com.company.designpattern.singletons.EagerSingleton;
import com.company.designpattern.singletons.EnumSingleton;
import com.company.designpattern.singletons.LazySingleton;

/**
 * @author Administrator
 */
public class PatternTest {
    public static void main(String[] args) {
//        System.out.println(LazySingleton.getInstance());
//        System.out.println(EagerSingleton.getInstance());
//        System.out.println(EnumSingleton.INSTANCE);

        Sheep sheep = new Sheep("tom",1,"white");
        sheep.friend = new Sheep("jack",2,"black");

        Sheep sheep2 = sheep.clone();
        Sheep sheep3 = sheep.clone();

        System.out.println("sheep2 = " + sheep2 + " sheep2.friend= " + sheep2.friend.hashCode());
        System.out.println("sheep3 = " + sheep3 + " sheep3.friend= " + sheep3.friend.hashCode());



    }
}
