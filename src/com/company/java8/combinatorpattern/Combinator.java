package com.company.java8.combinatorpattern;

import java.time.LocalDate;

public class Combinator {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "123214",
                LocalDate.of(2000,1,1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

    }
}
