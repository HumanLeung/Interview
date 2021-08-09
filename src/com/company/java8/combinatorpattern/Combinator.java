package com.company.java8.combinatorpattern;

import java.time.LocalDate;

import static com.company.java8.combinatorpattern.CustomerRegistrationValidator.*;

public class Combinator {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+0123214",
                LocalDate.of(2000,1,1)
        );

//        System.out.println(new CustomerValidatorService().isValid(customer));

          ValidationResult result = isEmailValid()
                        .and(isPhoneNumberValid())
                        .and(isAuAdult())
                        .apply(customer);

//                 System.out.println(result);
//
//                 if (result != ValidationResult.SUCCESS) {
//                     throw new IllegalArgumentException(result.name());
//                 }

    }
}
