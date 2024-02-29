package com.company.io.socket.file;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author Administrator
 */
public class ServerReadThread extends Thread{
    private Socket socket;
    public ServerReadThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try(DataInputStream dis = new DataInputStream(socket.getInputStream());
            OutputStream os = Files.newOutputStream(Paths.get("src/" + UUID.randomUUID().toString() + dis.readUTF()));){
            String suffix = dis.readUTF();
            System.out.println("服务端已经成功接收到了文件类型：" + suffix);
            byte[] buffer = new byte[1024];
            int len;
            while((len = dis.read(buffer)) > 0){
                os.write(buffer,0,len);
            }
            System.out.println("服务端接收文件保存成功！");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
