package com.company.java8.streams;

import com.company.java8.lambda.Gender;
import com.company.java8.lambda.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.company.java8.lambda.Gender.FEMALE;
// map function takes a function of some type that extends Person
// and then you can see the other one, so the other arguments or
//question mark extends are matter so this is exactly what we've
//learned right so a function takes an input and produces an output

// collect is a supplier and you can see by consumer so this is awesome

//Stream 自己不会存储元素
//Stream 不会改变源对象.相反，他们会返回一个持有结果的新Stream.
//Stream 操作是延迟执行额.意味着他们会等到需要结果的时候才执行.


public class StreamDemo {

    public static void main(String[] args) {
         List<Person> people = getPeople();
         Function<Person, String> personStringFunction = Person::getName;
         ToIntFunction<String> length = String::length;
         IntConsumer println = System.out::println;
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.getGender());

        boolean containsOnlyFemales = people.stream().allMatch(personPredicate);
        System.out.println(containsOnlyFemales);

//        Set<Gender> collect
          people.stream()
                 .map(Person::getGender)
                 .collect(Collectors.toSet())
                 .forEach(System.out::println);

          people.stream()
                  .map(Person::getName)
                  .mapToInt(String::length)
                  .forEach(System.out::println);


    }

    private static List<Person> getPeople(){
        return Arrays.asList(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, FEMALE),
                new Person("Helen Tong", 57, FEMALE),
                new Person("Alex Boz", 14,Gender.MALE),
                new Person("Jamie Goa", 99,Gender.MALE),
                new Person("Anna Ben", 13, FEMALE),
                new Person("Zelda Brown", 12,Gender.MALE),
                new Person("John King", 35,Gender.MALE)
        );
    }
}
