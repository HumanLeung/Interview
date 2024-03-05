package com.company.java8.functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Administrator
 */
public class SupplierDemo {
    public static void main(String[] args) {
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5412/users";
    }

    static Supplier<List<String>> getDBConnectionUrlSupplier = ()
            -> Arrays.asList("jdbc://localhost:5431/users",
            "jdbc://localhost:5431/customer");
}
