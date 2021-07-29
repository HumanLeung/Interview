package com.company.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrinterStream {
    public static void main(String[] args) throws FileNotFoundException {
        String data = "This is a text inside the file.";
        PrintStream output = new PrintStream("src/output.txt");
        int age = 25;
        output.printf("I am %d years old.\n",age);
        output.print(data);
        output.close();
    }
}
