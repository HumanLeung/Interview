package com.company.nio;
/*
一、Channel :用于源节点与目标节点的连接。在Java NIO 中负责缓冲区中数据的传输
. Channel 本身不存储数据，因此需要配合缓冲区进行操作
二、通过的主要实现类
FileChannel
SocketChannel
ServerSocketChannel
DatagramChannel

三、 获取通道
1、 Java 针对支持通道的类提供了getChannel()方法
    本地IO
    Socket
    FileInputStream/FileOutputStream
    RandomAccessFile

    网络IO:
    Socket
    ServerSocket
    DatagramSocket
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestChannel {
    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
   test3();
    }
     public static void test1() throws IOException { //非直接缓冲区
         FileInputStream fis = new FileInputStream("src/text.txt");
         FileOutputStream fos = new FileOutputStream("src/text2.txt");

         FileChannel inChannel = fis.getChannel();
         FileChannel outChannel = fos.getChannel();

         ByteBuffer buf = ByteBuffer.allocate(1024);

         while(inChannel.read(buf) != -1) {
             buf.flip();
             outChannel.write(buf);
             buf.clear();
         }
         outChannel.close();
         inChannel.close();
         fos.close();
         fis.close();
     }

     public static void test2() {
         try {
           FileChannel inChannel = FileChannel.open(Paths.get("src/text.txt"), StandardOpenOption.READ);
           FileChannel outChannel = FileChannel.open(Paths.get("src/text3.txt"), StandardOpenOption.WRITE,
                   StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);

            //内存映射文件
             MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
             MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

             byte[] dst = new byte[inMappedBuf.limit()];
             inMappedBuf.get(dst);
             outMappedBuf.put(dst);

             inChannel.close();
             outChannel.close();

         } catch (IOException e) {
             e.printStackTrace();
         }
     }
    public static void test3() throws IOException {
        //通道之间的数据传输(直接缓冲区)
        FileChannel inChannel = FileChannel.open(Paths.get("src/text.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("src/text3.txt"), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);


//        inChannel.transferTo(0,inChannel.size(),outChannel);
          outChannel.transferFrom(inChannel,0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }
}
