package com.company.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//带有缓冲区的流,因为有了缓冲区,读写的时间可以加快,并且,可以对源数据的某一部分进行反复读写
//        他用了包装者模式,构造这个类的对象的时候,需要一个基本流对象,比如
//        BufferedInputStream bin = new BufferedInputStream( new FileInputStream("XX"))
//        用这个流对文件进行读写,会比用FileInputStream之类的流的速度提高很大

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src/text.txt");
        BufferedWriter buffer = new BufferedWriter(fw);
        buffer.write("Welcome to javaPoint");
        buffer.close();
        System.out.println("Success");
    }
}
