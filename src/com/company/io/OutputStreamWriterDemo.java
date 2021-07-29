package com.company.io;

import java.io.*;

public class OutputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("src/output.txt");
        Writer writer = new OutputStreamWriter(outputStream);

        writer.write("Hello World");

        writer.close();
    }
}
