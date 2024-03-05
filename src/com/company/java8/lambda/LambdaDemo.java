package com.company.java8.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaDemo {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }
        females.forEach(System.out::println);
        System.out.println("regular expression ----------------------- ");


        List<Person> females2 = people.stream().filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        females.forEach(System.out::println);

        System.out.println("---------------------------");

        //Sort
       List<Person> sorted = people.stream().sorted(Comparator.comparing(Person::getAge)
               .thenComparing(Person::getGender))
                .collect(Collectors.toList());
       sorted.forEach(System.out::println);

        System.out.println("All match -----------------------------------");
       // All match
       boolean allMatch = people.stream().allMatch(person -> person.getAge() > 5);
        System.out.println(allMatch);

        System.out.println("anyMatch -----------------------------------");
        //anyMatch
        boolean anyMatch = people.stream().anyMatch(person -> person.getAge()>8);
        System.out.println(allMatch);

        boolean noneMatch = people.stream().noneMatch(person -> person.getName().equals("haha"));
        System.out.println(noneMatch);

        //max
       people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

       //grouping
        Map<Gender,List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        System.out.println(groupByGender);
        groupByGender.forEach((gender, people1) -> {
            people1.forEach(System.out::println);
        });

        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);


        Optional.of(oldestFemaleAge).ifPresent(Optional::get);
        System.out.println(oldestFemaleAge.get()+"oldestFemale");
        oldestFemaleAge.ifPresent(System.out::println);
    }

    private static List<Person> getPeople(){
        return Arrays.asList(
          new Person("James Bond", 20,Gender.MALE),
                new Person("Alina Smith", 33,Gender.FEMALE),
                new Person("Helen White", 57,Gender.FEMALE),
                new Person("Alex Boz", 14,Gender.MALE),
                new Person("Jamie Goa", 99,Gender.MALE),
                new Person("Anna Cook", 13,Gender.FEMALE),
                new Person("Zelda Brown", 12,Gender.MALE),
                new Person("John King", 35,Gender.MALE)
                );
    }
}
