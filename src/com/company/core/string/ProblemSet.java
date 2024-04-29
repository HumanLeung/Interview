package com.company.core.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class ProblemSet {
    public static void main(String[] args) {
        String sentence = "alex brian charles alex charles david eric david";
        String blogName = "How To Do In Java";
        findDuplicated(sentence);
        reverseStringInRecursion(blogName);
        reverseStringInStringBuilder(blogName);
    }

    public static void findDuplicated(String sentence){
        List<String> wordsList = Arrays.stream(sentence.split(" ")).collect(Collectors.toList());
        Set<String> tempSet = new HashSet<>();
        //如果Set.add返回false则代表已经存在数据。
        List<String> duplicateWords = wordsList.stream()
                .filter(w -> !tempSet.add(w))
                .collect(Collectors.toList());
        System.out.println(duplicateWords);

        Map<String, Integer> wordsMapWithCount = wordsList.stream()
                .collect(Collectors.toMap(Function.identity(), word -> 1, Math::addExact));
        System.out.println(wordsMapWithCount);

        Map<String, Integer> dupWordsMapWithCount = wordsMapWithCount.entrySet()
                .stream().filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(dupWordsMapWithCount);
    }

    public static void findDuplicatedByCollection(String sentence){
        List<String> wordsList = Arrays.asList(sentence.split(" "));
        Set<String> tempSet = new HashSet<>();
        List<String> duplicateWords = new ArrayList<>();
        for (String word : wordsList) {
            if (!tempSet.add(word)) {
                duplicateWords.add(word);
            }
        }
        System.out.println(duplicateWords);

        Map<String, Integer> dupWordsMapWithCount = new HashMap<>(duplicateWords.size());
        for (String word : duplicateWords) {
            dupWordsMapWithCount.put(word, Collections.frequency(wordsList, word));
        }
        System.out.println(dupWordsMapWithCount);
    }

    public static void reverseStringInRecursion(String blogName){
        String reverseString = reverseString(blogName);
        System.out.println(reverseString);
    }
    public static String reverseString(String string) {
        if (string.isEmpty()) {
            return string;
        }
        return reverseString(string.substring(1)) + string.charAt(0);
    }

    public static void reverseStringInStringBuilder(String blogName){
        String reverseString = new StringBuilder(blogName).reverse().toString();
        System.out.println(reverseString);
    }


}
