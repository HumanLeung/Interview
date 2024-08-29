package com.company.annotation;

//Override
//Deprecated
//SuppersWarnings


@EmptyAnnotation
public class AnnoDemo {

    private static final int THING = 3;

//    @EmptyAnnotation
    public static void main(String[] args) {

    }

    @FilledAnnotation(name = "Bob", value = 13)
    public static void doSomething() {
        System.out.println("it is cool");
    }
}
