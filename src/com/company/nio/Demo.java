package com.company.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("src/nio.txt");
//        Path createdPath =  Files.createFile(path);
//        System.out.println("Created a file at : "+createdPath);
//        copyFile();
//        NioWrite();
        createDir();
    }

    public static void copyFile() {
        Path sourceFile = Paths.get("src/testout.txt");
        Path targetFile = Paths.get("src/nio.txt");

        try {
            Files.copy(sourceFile,targetFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path wiki_path = Paths.get("src/nio.txt");
        try {
           List<String> lines = Files.readAllLines(wiki_path);
            for (String line: lines) {
                System.out.println(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void NioWrite() throws IOException {
        Path path = Paths.get("src/text.txt");
        String question = "To be or not to be?";
        Charset charset = StandardCharsets.ISO_8859_1;
       Files.write(path, question.getBytes());
       List<String> lines = Files.readAllLines(path,charset);
//        new ConcurrentHashMap().put()
       for (String line: lines) {
           System.out.println(line);
       }
    }
    public static void createDir() throws IOException {
        Path path = Paths.get("src/newDir");
        Path  Dir = Files.createDirectories(path);
        System.out.println(Dir);
    }
}
