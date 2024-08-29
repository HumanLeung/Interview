package com.company.huawei.string;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String [] str = {"abcc","abcc","abcb"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix (String[] strs) {
        if (!Objects.isNull(strs) && strs.length != 0){
            strs = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);

            int itemLengths = strs.length;
            String longestPrefix = "";
            String firstOne = strs[0];
            int firstOneLentgh = firstOne.length();
            String compareText = "";
            if (strs.length > 1){
                for (int i = 0; i < firstOneLentgh; i++) {
                    compareText = compareText + firstOne.charAt(i);
                    String oldLongestString = longestPrefix;
                    for (int j = 1; j < itemLengths; j++) {
                        int compareLength = compareText.length();
                        if (strs[j].length() >= compareLength) {
                            if (Objects.equals(compareText, strs[j].substring(0, compareLength))) {
                                longestPrefix = strs[j].substring(0, compareLength);
                            }else{
                                return oldLongestString;
                            }
                        }
                    }
                }
                return longestPrefix;
            }else{
                return strs[0];
            }
        }
        return "";
    }
}
