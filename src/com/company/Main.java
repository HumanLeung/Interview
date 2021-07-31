package com.company;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        server();
        
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
