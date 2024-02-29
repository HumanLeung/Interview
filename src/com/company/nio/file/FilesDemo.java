package com.company.nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Administrator
 */
public class FilesDemo {
    public static void main(String[] args) {

        Path path = Paths.get("src/text.txt");
        try{
            byte[] bytes = Files.readAllBytes(path);
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);
            System.out.println(new String(bytes));

        }catch (IOException e){
          e.printStackTrace();
        }
    }
}
