package com.company.core.string;

import java.util.StringJoiner;

/**
 * @author Administrator
 */
public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",", "(", ")").add("hello").add("guys").add("欢迎大家");
        System.out.println(stringJoiner);

    }
}
