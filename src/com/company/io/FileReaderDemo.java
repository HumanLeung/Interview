package com.company.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
       readFile();
    }

    public static void readFile() throws IOException {
        char [] array = new char[100];
        FileReader input = new FileReader("src/data.txt");
        input.read(array);
        System.out.println("Data in the file");
        System.out.println(array);
        input.close();
    }
}
