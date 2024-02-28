package com.company.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author Administrator
 */
public class OutputStreamWriterDemo {
    public static void main(String[] args) {
          writeText();
    }
    public static void writeText(){
        // 文件路径
        String filePath = "src/gle.txt";
        // 要写入的内容
        String content = "Here is something for you!";
        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)){
            // 将字符串写入到文件中, 写入指定长度的内容
            outputStreamWriter.write(content,0,content.length());
        }catch (IOException e){
           e.printStackTrace();
        }
    }
}
