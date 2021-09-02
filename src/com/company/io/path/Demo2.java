package com.company.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\Administrator\\Desktop\\喵，请许愿");
        List<Path> result = findByFileName(path,"叶辰.txt");
        result.forEach(System.out::println);
    }

    public static List<Path> findByFileName(Path path, String fileName) throws IOException {
        List<Path> result;
        try(Stream<Path> pathStream = Files.find(path,Integer.MAX_VALUE,
                (p,basicFileAttributes) -> p.getFileName().toString().equalsIgnoreCase(fileName))
        ){
            result = pathStream.collect(Collectors.toList());
            System.out.println(result);
        }
        return result;
    }
    public static void checkFile(Path path,String fileName){
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) ->{
                    // if directory or no-read permission, ignore
                    if(Files.isDirectory(p) || !Files.isReadable(p)){
                        return false;
                    }
                    return p.getFileName().toString().equalsIgnoreCase(fileName);
                })
        ){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
