package com.company.java8.lambda;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
}
