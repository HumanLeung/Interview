package com.company.object;

import java.util.Arrays;

public class DeepCopy {
    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        Ex2 e = new Ex2(vals);
        e.showData();
        vals[0] = 13;
        e.showData();
        System.out.println(Arrays.toString(vals));
    }
}

class Ex2 {
    private int [] data;

    public Ex2(int[] values) {
        data = new int[values.length];
        for (int i = 0; i < data.length; i++) {
            data[i] = values[i];
        }
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}
