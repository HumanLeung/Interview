package com.company.java8.lambda;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Administrator
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private  String name;
    private  int age;
    private Gender gender;
}
