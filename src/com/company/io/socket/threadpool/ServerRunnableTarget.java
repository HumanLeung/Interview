package com.company.io.socket.threadpool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Administrator
 */
public class ServerRunnableTarget implements Runnable{
    private final Socket socket;

    public ServerRunnableTarget(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
      try(InputStream is = socket.getInputStream();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));){
      String msg;
      while((msg = bufferedReader.readLine()) != null) {
          System.out.println("服务的收到：" + msg);
      }
      }catch (IOException e){
          e.printStackTrace();
      }
    }
}
