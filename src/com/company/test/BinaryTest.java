package com.company.test;

import java.io.File;

public class BinaryTest {
    public static void main(String[] args) {
        System.out.println(1 << 30);
        System.out.println(1073741824 >>> 1);
        System.out.println(5 >>> 1);
        System.out.println(13 << 1);
        System.out.println(26 << 1);
        System.out.println(16 << 1);
        System.out.println(32 << 1);
        File file = new File("h:\\Test");
        for (File file1 : file.listFiles()){
            System.out.println(file1.getName());
        }
    }
}
