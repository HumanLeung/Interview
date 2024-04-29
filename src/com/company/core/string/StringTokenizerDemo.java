package com.company.core.string;

import java.util.StringTokenizer;

/**
 * @author Administrator
 */
public class StringTokenizerDemo {
    public static void main(String[] args) {
        String sentence = "Hello, world! Welcome to StringTokenizer.";
        StringTokenizer tokenizer = new StringTokenizer(sentence, " ,!.");
        System.out.println(tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
        String [] stringArray = sentence.split(" ,");
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
}
