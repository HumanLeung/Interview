package com.company.java8.combinatorpattern;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String email;
    private final String phoneNum;
    private final LocalDate dob;

    public Customer(String name, String email, String phoneNum, LocalDate dob){
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public LocalDate getDob() {
        return dob;
    }
}
