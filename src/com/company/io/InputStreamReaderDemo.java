package com.company.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Administrator
 */
public class InputStreamReaderDemo {
    public static void main(String[] args) {
        inputStreamTest();
    }

    public static void inputStreamTest(){
        try(FileInputStream fileInputStream = new FileInputStream("src/text.txt");
            //转换流字节转文本
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader)){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
          e.printStackTrace();
        }
    }
}
