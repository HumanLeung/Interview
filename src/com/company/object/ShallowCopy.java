package com.company.object;

import java.util.Arrays;

public class ShallowCopy {
    public static void main(String[] args) {
        int[] vals = {3, 7, 9};
        Ex e = new Ex(vals);
        e.showData();
        vals[0] = 13;
        e.showData();

    }
}

class Ex {
    private int[] data;

    public Ex(int[] values) {
        data = values;
    }
    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}
