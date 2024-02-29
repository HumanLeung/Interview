package com.company.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author Administrator
 */
public class NioServer {
    public static void main(String[] args) {
        System.out.println("----NIO服务端启动----");
        try(ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //1.获取通道
            Selector selector = Selector.open();){
            //2.切换为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //3.绑定连接的端口
            serverSocketChannel.bind(new InetSocketAddress(9999));
            //5.将通道都注册到选择器上去，并且开始指定监听接收事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //6.使用Selector选择器轮询已经就绪好的事件
            while(selector.select() > 0){
                System.out.println("开始一轮事件处理");
                //7.获取选择器中的所有注册的通道中已经就序好的事件
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                //8.开始遍历这些准备好的事件
                while(it.hasNext()){
                    //提取当前这个事件
                    SelectionKey sk = it.next();
                    //9.判断这个事件具体是什么事件
                    if (sk.isAcceptable()){
                        //10.直接获取当前接入的客户端通道
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        //11.将客户端通道也设置为非阻塞式的
                        socketChannel.configureBlocking(false);
                        //12.将客户端通道也注册到选择器Selector上
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if (sk.isReadable()){
                        //13.获取当前选择器上的”读就绪事件“
                        SocketChannel socketChannel = (SocketChannel) sk.channel();
                        //14.开始读取数据
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while((len = socketChannel.read(buffer)) > 0)  {
                            buffer.flip();
                            System.out.println(new String(buffer.array(),0,len));
                            //”清除“之前的数据
                            buffer.clear();
                        }
                    }
                    //处理完毕当前事件后，需要移除掉当前事件.否则会重复处理
                    it.remove();
                }
            }
        }catch (IOException e){
          e.printStackTrace();
        }
    }
}
