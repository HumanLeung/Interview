package com.company.io;

import java.io.*;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream stream = new FileInputStream("src/text.txt");
        Reader reader = new InputStreamReader(stream);
        int data = reader.read();
        while (data != -1) {
            System.out.print((char)data);
            data = reader.read();
        }
    }
}
