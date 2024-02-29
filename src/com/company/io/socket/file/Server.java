package com.company.io.socket.file;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 */
public class Server {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(8888);){
            while(true){
                Socket socket = ss.accept();
                new ServerReadThread(socket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
