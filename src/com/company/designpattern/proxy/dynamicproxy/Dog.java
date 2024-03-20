package com.company.designpattern.proxy.dynamicproxy;

/**
 * @author Administrator
 */
public class Dog implements Animal{
    private String name;
    public Dog() {
    }
    public Dog(String name) {
        this.name = name;
    }
    @Override
    public void wakeup() {
        System.out.println("小狗"+name+"早晨醒来啦");
    }
    @Override
    public void sleep() {
        System.out.println("小狗"+name+"晚上睡觉啦");
    }
}
