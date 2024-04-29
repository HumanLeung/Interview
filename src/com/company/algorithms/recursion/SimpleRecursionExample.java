package com.company.algorithms.recursion;

import java.io.File;

/**
 * @author Administrator
 */
public class SimpleRecursionExample {
    public static void main(String[] args) {
//        callMyself(9);
        searchFile(new File("D:/"),"WeChat.exe");
    }

    public static void callMyself(long i) {
        if (i < 0) {
            return;
        }
        System.out.print(i);
        i = i - 1;
        callMyself(i);
    }

    private static void searchFile(File dir, String fileName){
        if (dir != null && dir.isDirectory()){
            File[] files = dir.listFiles();
            if (files != null){
                for (File file : files){
                    if (file.isFile()){
                        if (file.getName().contains(fileName)){
                            System.out.println(fileName+"文件的绝对路径为："+file.getAbsolutePath());
                        }
                    }else{
                        searchFile(file, fileName);
                    }
                }
            }
        }else{
            System.out.println("该文件不是一个目录，或者该目录为空！！！！");
        }
    }
}
