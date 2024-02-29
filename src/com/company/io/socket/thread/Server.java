package com.company.io.socket.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 */
public class Server {
    public static void main(String[] args) {
        System.out.println("====服务端启动====");
        //1.定义一个ServerSocket对象进行服务端的端口注册
        try(ServerSocket ss = new ServerSocket(9999);){
            while(true){
                Socket socket = ss.accept();
                new ServerThreadReader(socket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

}
