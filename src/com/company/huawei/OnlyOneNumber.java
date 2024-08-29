package com.company.huawei;

/**
 * @author Administrator
 */
public class OnlyOneNumber {
    public static void main(String[] args) {
        System.out.println(5 ^ 2);
        System.out.println(7 ^ 1);
        System.out.println(6 ^ 2);
         int [] nums = new int []{4,1,2,1,2};
        System.out.println(singleNumber(nums) + "result");
    }
    public static int singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums){
            x ^= num;
            System.out.print(x);
        }
        return x;
    }
}
