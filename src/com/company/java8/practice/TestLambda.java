package com.company.java8.practice;

import com.company.java8.lambda.Gender;
import com.company.java8.lambda.MyFun;
import com.company.java8.lambda.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.company.java8.lambda.Gender.FEMALE;

public class TestLambda {
    public static void main(String[] args) {
        List<Person> peoples = getPeople();
       TestLambda testLambda = new TestLambda();
//        System.out.println(testLambda.test1(peoples));
        System.out.println(testLambda.strHandler("What is your name", String::toUpperCase));
    }

    public List<Person> test1(List<Person> people) {
        people.sort((o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return people;
    }
    public String strHandler(String str, MyFunction myFun) {
        return myFun.getValue(str);
    }

    private static List<Person> getPeople(){
        return Arrays.asList(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, FEMALE),
                new Person("Helen Tong", 57, FEMALE),
                new Person("Alex Boz", 14,Gender.MALE),
                new Person("Jamie Goa", 99,Gender.MALE),
                new Person("Lin Ben", 13, FEMALE),
                new Person("Zelda Brown", 12,Gender.MALE),
                new Person("John King", 35,Gender.MALE)
        );
    }
}
