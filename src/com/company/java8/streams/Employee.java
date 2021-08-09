package com.company.java8.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {
    private String name;
    private Integer age;
    private Integer salary;
}
