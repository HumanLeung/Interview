package com.company;

import com.company.annotation.EmptyAnnotation;
import com.company.annotation.MyAnnotation;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

@EmptyAnnotation
public class Main {

    int[] tab = new int[16];

    public static void main(String[] args) throws IOException {
//        for(int i = 0; i < args.length; i++) {
//            System.out.println( args[i] );
//        }

        ArrayList<String> arrayList = new ArrayList(10);

        Class<?> t = Main.class;
        MyAnnotation emptyAnnotation = t.getAnnotation(MyAnnotation.class);
        System.out.println(emptyAnnotation instanceof MyAnnotation);
        System.out.println(arrayList instanceof List);

        System.out.println(System.getProperty("org.graalvm.nativeimage.imagecode"));
        System.out.println(6 >> 1);
        System.out.println(5 / 2);
        System.out.println(1 << 30);
        System.out.println(Integer.MAX_VALUE);

        new Main().tab();

    }

    public void tab(){
        tab[2] = 12;
        System.out.println(tab[2]);
        System.out.println(tab.length);
    }

    public static void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("src/text2.txt"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //2. 绑定连接
        ssChannel.bind(new InetSocketAddress(9998));

        //3.获取客户端连接的通道
        SocketChannel socketChannel = ssChannel.accept();

        //4.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //5. 接受客户端的数据,并保存到本地
        while(socketChannel.read(buf) != -1) {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //6. 关闭通道
        ssChannel.close();
        outChannel.close();
        ssChannel.close();
    }
}
