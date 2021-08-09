package com.company.java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//可以通过Collection 系列集合提供的stream() 或 parallelStream()
public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String [] emp = new String[10];
        Stream<String> string = Arrays.stream(emp);

        Stream<String> stream3 = Stream.of("aa","bb");

    }
}
