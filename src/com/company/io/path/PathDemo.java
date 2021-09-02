package com.company.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathDemo {
    public static void main(String[] args) throws IOException {
        System.out.println("The home folder is: "+ System.getProperty("user.home"));
        System.out.println("The path to this program is: "+System.getProperty("user.dir"));
        System.out.println("The path to this program is: "+System.getProperty("os.name"));
        System.out.println("The path to this program is: "+System.getProperty("os.version"));
        System.out.println("The path to this program is: "+System.getProperty("user.name"));
        System.out.println("The path to this program is: "+System.getProperty("java.class.path"));
        System.out.println("The path to this program is: "+System.getProperty("file.separator"));


        Path file =  Paths.get("C:\\Users\\Administrator\\Desktop\\share\\log.txt");
        long size = Files.size(file);
        System.out.println(Math.ceil(size));
        long kb = 0;
        while(size != 0)
        {
             kb = size % 10L;
             size = size / 10L;
        }
        System.out.println(kb+1);

        String extension = "";

        int index = file.toString().lastIndexOf('.');
        if (index > 0) {
            extension = file.toString().substring(index + 1);
        }

    }
}
