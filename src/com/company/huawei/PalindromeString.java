package com.company.huawei;

/**
 * @author Administrator
 */
public class PalindromeString {

    public static void main(String[] args) {

        String str = "cdabbacc";
        int max = 0;
        for (int i = 0; i < str.length(); i++){
            for (int j = str.length(); j > i; j--){
                String toBejuged = str.substring(i,j);
                if (isPalindDromeString(toBejuged)){
                    max = Math.max(max, j - i);
                }
            }
        }

    }

    public static boolean isPalindDromeString(String str){
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
