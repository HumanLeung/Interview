package com.company.java8.functional;

import com.company.java8.lambda.Gender;
import com.company.java8.lambda.Person;
import static com.company.java8.lambda.Gender.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FunctionDemo {
    public static void main(String[] args) {

        List<Person> arrayList = getPeople();
        for (Person female : arrayList) {
            System.out.println(female);
        }

        Predicate<Person> females2 = person -> FEMALE.equals(person.getGender());
        System.out.println("Predicate");
        System.out.println(females2);

        System.out.println("Stream");
        arrayList.stream().filter(females2).collect(Collectors.toList())
                .forEach(System.out::println);
    }
    private static List<Person> getPeople(){
        return Arrays.asList(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, FEMALE),
                new Person("Helen Tong", 57, FEMALE),
                new Person("Alex Boz", 14,Gender.MALE),
                new Person("Jamie Goa", 99,Gender.MALE),
                new Person("Anna Cook", 13, FEMALE),
                new Person("Zelda Brown", 12,Gender.MALE),
                new Person("John King", 35,Gender.MALE)
        );
    }
}
