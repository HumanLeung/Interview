package com.company.java8.optionals;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalDemo {
    public static void main(String[] args) {

        Supplier<IllegalArgumentException> exception = () -> new IllegalArgumentException("something wrong");

        String phone = "12345";
       Object value = Optional.ofNullable(phone)
//                .orElseGet(() -> "default value");
        .orElseThrow(() -> new IllegalArgumentException("exception"));

        System.out.println(value);

        Optional.ofNullable("Nice").ifPresent(System.out::println);

        System.out.println(Optional.empty());

        Optional.ofNullable(null).ifPresent(email -> System.out.println(email+"com"));
    }
}
