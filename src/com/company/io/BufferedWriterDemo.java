package com.company.io;

import java.io.*;

//带有缓冲区的流,因为有了缓冲区,读写的时间可以加快,并且,可以对源数据的某一部分进行反复读写
//        他用了包装者模式,构造这个类的对象的时候,需要一个基本流对象,比如
//        BufferedInputStream bin = new BufferedInputStream( new FileInputStream("XX"))
//        用这个流对文件进行读写,会比用FileInputStream之类的流的速度提高很大

/**
 * @author Administrator
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        try(FileWriter fw = new FileWriter("src/text.txt");
            BufferedWriter buffer = new BufferedWriter(fw);){

            buffer.write("Welcome to javaPoint");
            System.out.println("Success");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void copyText() {
        String sourceFilePath = "src/text.txt";
        String targetFilePath = "bufferText.txt";
        File file = new File(sourceFilePath);
        // 输入流
        try (Reader reader = new FileReader(file);
             // 输出流
             Writer writer = new FileWriter(targetFilePath);
             // 使用默认的缓冲区大小来创建缓冲字符输入流，默认大小为8192个字符
             BufferedReader bufferedReader = new BufferedReader(reader);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
             String result;
            while ((result = bufferedReader.readLine()) != null) {
                // 换行 result 是一行数据，所以每写一行就要换行
                writer.write(result);
                bufferedWriter.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("执行完成！");
    }
}
