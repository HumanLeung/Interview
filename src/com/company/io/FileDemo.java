package com.company.io;


import java.io.FileWriter;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/data.txt");
            fileWriter.write("hahahah\n");
            fileWriter.append("asdasd");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
