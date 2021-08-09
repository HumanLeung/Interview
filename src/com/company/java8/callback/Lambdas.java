package com.company.java8.callback;

import com.company.java8.combinatorpattern.Customer;

import java.time.LocalDate;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String,Customer> upperCaseName = name -> {
            //login
            if (name.isEmpty()) throw new IllegalArgumentException("wrong");
            return new Customer("asd","asd", "ads", LocalDate.now());
        };

        System.out.println(upperCaseName.apply("12"));
    }
}
