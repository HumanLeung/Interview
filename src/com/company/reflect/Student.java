package com.company.reflect;

import jdk.nashorn.internal.ir.annotations.Reference;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class Student extends Person<Student,Integer>{
    public void test01(@Reference Map<String,Person> map, List<Person> list){
        System.out.println("Demo.test01()");
    }
    public Map<Integer,Person> test02(){
        System.out.println("Demo.test02()");
        return null;
    }
}
