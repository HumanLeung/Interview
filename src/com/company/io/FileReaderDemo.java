package com.company.io;

import java.io.*;

/**
 * @author Administrator
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        readTest();
        writeTest();
    }

    public static void readFile() throws IOException {
        char [] array = new char[100];
        FileReader input = new FileReader("src/data.txt");
        input.read(array);
        System.out.println("Data in the file");
        System.out.println(array);
        input.close();
    }

    public static void readTest(){
        File file = new File("src/data.txt");
        try (FileReader fileReader = new FileReader(file);
             //文本输入缓冲流
             BufferedReader bufferedReader = new BufferedReader(fileReader)){
            int len;
            char[] fileChars = new char[1024*1024];
            while((len = bufferedReader.read(fileChars)) != -1){
                // 为什么不采用 String string = new String(fileChars);
                // 因为最后一次读取的时候，可能不足5个，这样就会出现乱码
                String string = new String(fileChars,0, len);
                System.out.println(string);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeTest(){
        String filePath = "src/writeTxt.txt";
        char [] chars = {'y', 'y'};
        try(FileWriter fileWriter = new FileWriter(filePath)){
             fileWriter.write(chars);
            //写入数组的指定部分
             fileWriter.write("new info");
            //写入整个字符串
             fileWriter.write("Blog,666".toCharArray(),0,4);
            //写入字符串指定的指定部分
             fileWriter.write("new line",0,2);
        } catch (IOException e){
             e.printStackTrace();
        }
    }
}
