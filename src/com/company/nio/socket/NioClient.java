package com.company.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class NioClient {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0",9999);
        //1.获取通道
        try(SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);){
            //2.切换为非阻塞模式
            socketChannel.configureBlocking(false);
            //3.分配指定缓存区大小
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //4.发送数据给服务端
            Scanner sc = new Scanner(System.in);
            String msg = null;
            while(!Objects.equals(msg, String.valueOf(0))){
                System.out.println("请输入: ");
                msg = sc.nextLine();
                buffer.put(("King: " + msg).getBytes());
                buffer.flip();
                socketChannel.write(buffer);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
