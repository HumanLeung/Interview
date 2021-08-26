package com.company.java8.functional;

import java.util.Collections;
import java.util.function.Predicate;

public class PredicateDemo {
    //Represents a predicate (boolean valued function) of one argument
    public static void main(String[] args) {
        System.out.println(isPhoneNumberValidPredicate.test("07932100000"));
        System.out.println(isPhoneNumberValidPredicate.test("09"));

        System.out.println(isPhoneNumberValidPredicate
                .and(containsNumber3).test("07932100000"));

        System.out.println(isPhoneNumberValidPredicate
                .or(containsNumber3).test("07932100000"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

//    static Predicate<String> isPhoneNumberValidPredicate = PredicateDemo::isPhoneNumberValid
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
        phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
