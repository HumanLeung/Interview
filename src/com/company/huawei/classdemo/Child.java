package com.company.huawei.classdemo;

/**
 * @author Administrator
 */
public class Child extends Person{
    public String grade;

    public Child(){
        super();
    }

    public static void main(String[] args) {
        Person p = new Child();
        System.out.println(p);
    }
}
