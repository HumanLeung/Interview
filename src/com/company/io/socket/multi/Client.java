package com.company.io.socket.multi;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
            Scanner sc = new Scanner(System.in);
            String msg = null;
            do{
                System.out.print("输入");
                msg = sc.nextLine();
                ps.println(msg);
            }while (!String.valueOf(0).equals(msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
