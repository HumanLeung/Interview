package com.company.io.socket.single;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author Administrator
 */
public class Client {
    public static void main(String[] args) {
        //1.创建Socket对象请求服务端的连接
        try (Socket socket = new Socket("127.0.0.1",9999);){
            //2.从Socket对象中获取一个字节输出流
            OutputStream os = socket.getOutputStream();
            //3.把字节输出流包装成一个打印流
            PrintStream ps = new PrintStream(os);
            ps.println("Hello World! 服务端，你好");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
