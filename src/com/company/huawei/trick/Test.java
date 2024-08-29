package com.company.huawei.trick;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        int index = 1;
        boolean[] test = new boolean[3];
        boolean foo = test[index];
        System.out.println(foo);

        double t = 0.9F;
        System.out.println(t);
        t = 0.8D;
        long g = 2L;
        System.out.println(t);
        System.out.println(g);

        double d = 1.0;
        short s = 1;

        String str = "$bo*y gi!r#l";
        String[] words = str.split("[^A-Za-z]+");
        System.out.println(Arrays.toString(words));
    }
}
