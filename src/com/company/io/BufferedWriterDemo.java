package com.company.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src/text.txt");
        BufferedWriter buffer = new BufferedWriter(fw);
        buffer.write("Welcome to javaPoint");
        buffer.close();
        System.out.println("Success");
    }
}
