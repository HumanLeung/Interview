package com.company.io.socket.threadpool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(9999)){
            HandleSocketServerPool pool = new HandleSocketServerPool(3,10);
            while(true){
                Socket socket = ss.accept();
                Runnable target = new ServerRunnableTarget(socket);
                pool.execute(target);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
