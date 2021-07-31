package com.company.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO {
    // 非堵塞 NIO 三个核心
//    1. 通道(channel): 负责连接
//         java.nio.channels.Channel
//           SelectableChannel
//           SocketChannel
//           ServerSocketChannel
//           DatagramChannel

//           Pipe.SinkChannel
//           Pipe.SourceChannel

//    2. 缓冲区(Buffer):负责数据的存取
//    3. 选择器(Selector): 是SelectableChannel的多路复用器.
//    用户监控SelectableChanel的IO状况

    public static void main(String[] args) throws IOException, InterruptedException {
//        server();
//        Thread.sleep(2000);
        client();
    }

    public static void client() throws IOException {
      SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9998));

        FileChannel inChannel = FileChannel.open(Paths.get("src/text.txt"), StandardOpenOption.READ);
      //2. 分配指定大小的缓存区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //3.读取本地文件, 并发送到服务器
        while(inChannel.read(buf) != -1) {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        //4. 关闭通道
         inChannel.close();
        sChannel.close();
    }

    public static void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("src/text2.txt"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

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
