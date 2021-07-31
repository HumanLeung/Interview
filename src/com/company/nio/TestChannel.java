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
    聚集写入 Gathering Writes 是指将多个Buffer中的数据"聚集"到Channel
    分散读取 Scattering Reads : 将通道中的数据分散到多个缓冲区中

    六、 字符集: Charset
    编码： 字符串 -> 字节数组
    解码:  字节数组 -> 字符串
 */

import javafx.scene.effect.SepiaTone;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

public class TestChannel {
    public static void main(String[] args) throws IOException {
//        test1();
//        test2();
//     test3();
//        test4();
          test5();
//        test6();

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

    public static void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("text.txt","rw");
        // get channel
        FileChannel channel1 = raf1.getChannel();

        // 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        // 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer byteBuffer: bufs) {
            byteBuffer.flip();
        }
        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));


        //4, 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("text2.txt","rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);
    }
    public static void test5() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");
        CharsetEncoder ce = cs1.newEncoder();
        CharsetDecoder cd = cs1.newDecoder();
         CharBuffer cBuf = CharBuffer.allocate(1024);
         cBuf.put("nice to see you here");
         cBuf.flip();

         //编码
        ByteBuffer bBuf = ce.encode(cBuf);
        for (int i = 0; i < 20; i++) {
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2);

        System.out.println("-------------------------------------------");
        Charset cs2 = StandardCharsets.UTF_8;
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3);


    }

    public static void test6() {
      Map<String, Charset> map = Charset.availableCharsets();
      Set<Map.Entry<String, Charset>> set = map.entrySet();

      for (Map.Entry<String, Charset> entry :set) {
          System.out.println(entry.getKey() + " = " + entry.getValue());
      }
    }
}
