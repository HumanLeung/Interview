package com.company.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("src/output.txt");
        BufferedReader br = new BufferedReader(fr);
        int i;
        while ((i=br.read())!=-1) {
            System.out.print((char)i);
        }
    }
}
