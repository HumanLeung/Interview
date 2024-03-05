package com.company.java8.functional;

import com.company.collections.Student;
import com.company.java8.lambda.Gender;
import com.company.java8.lambda.Person;
import static com.company.java8.lambda.Gender.*;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * @author Administrator
 */
public class FunctionDemo {
    public static void main(String[] args) {

        List<Person> arrayList = getPeople();

        Integer max = arrayList.stream().collect(Collectors.reducing(0,Person::getAge, Integer::sum));
        System.out.println(max);

        Map<Gender,Optional<Person>> eldestByClass = arrayList.stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors
                .reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getAge)))));

        System.out.println(eldestByClass);

        Map<Gender,String> stuMax = arrayList.stream().collect(Collectors.groupingBy(Person::getGender,
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Person::getAge)),
                        v -> v.orElseGet(Person::new).getName())));
        System.out.println(stuMax);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

// 使用Collectors.reducing查找最大值
        Optional<Integer> maxNum = numbers.stream()
                .reduce(Integer::max);

// 打印结果
        System.out.println("Max: " + maxNum.orElse(0));

//        Predicate<Person> females2 = person -> FEMALE.equals(person.getGender());
//        System.out.println("Predicate");
//        System.out.println(females2);
//
//        System.out.println("Stream");
//        arrayList.stream().filter(females2).collect(Collectors.toList())
//                .forEach(System.out::println);
//
//        Set<Person>set = arrayList.stream().filter(females2).collect(Collectors.toSet());
//        set.forEach(value -> {
//            System.out.println(value+"this is set");
//        });
//
//        List<Person> newArrayList = arrayList.stream().filter(females2).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(newArrayList);
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
