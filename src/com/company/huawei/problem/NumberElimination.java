package com.company.huawei.problem;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class NumberElimination {
    public static int[] eliminateNumbers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }

        int writeIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[writeIndex] != numbers[i]) {
                numbers[++writeIndex] = numbers[i];
            }
        }

        return Arrays.copyOf(numbers, writeIndex + 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 5};
        int[] result = eliminateNumbers(nums);
        System.out.println(Arrays.toString(result)); // 输出: [1, 2, 3, 4, 5]
    }
}
