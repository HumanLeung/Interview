package com.company.nio.file;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
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
            lines.add("new items");
            Files.write(path, bytes, StandardOpenOption.APPEND);
            Files.write(path, lines, StandardCharsets.UTF_8,StandardOpenOption.APPEND);
            Path directory = Files.createDirectory(path);
            Path directories = Files.createDirectories(path);

            Path newPath = Paths.get("b.txt");
            Path file = Files.createFile(path);

            Files.isHidden(file);
            Files.size(file);

            FileStore fileStore = Files.getFileStore(file);
            System.out.println(fileStore.getTotalSpace());

            Path path1 = Paths.get("a.txt");
            Path path2 = Paths.get("c.txt");
            Path copy = Files.copy(path1,path2);
            Path move = Files.move(path1, path2);

            Path root = file.getRoot();

            try(InputStream inputStream = Files.newInputStream(path,StandardOpenOption.APPEND);
                OutputStream outputStream = Files.newOutputStream(path);
                Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND);
                Reader reader = Files.newBufferedReader(path);){
                System.out.println(inputStream);
                System.out.println(outputStream);
                System.out.println(writer);
                System.out.println(reader);
            }catch (IOException e){
              e.printStackTrace();
            }

        }catch (IOException e){
          e.printStackTrace();
        }
    }
}
