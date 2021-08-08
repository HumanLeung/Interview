package com.company.java8.optionals;

import com.company.java8.combinatorpattern.Customer;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalDemo2 {
    public static void main(String[] args) {
        Customer customer = null;
        Customer customer1 = new Customer("12","asd","asd",LocalDate.now());
//        Optional<Customer> empty = Optional.of(customer);
        Optional<Customer> empty = Optional.ofNullable(customer);
        System.out.println(empty.isPresent());
        Customer customer2 = empty.orElse(customer1);
        System.out.println(customer2);


    }
}
